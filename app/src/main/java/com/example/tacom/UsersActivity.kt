package com.example.tacom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tacom.dao.UserDao
import com.example.tacom.database.AppDatabase
import com.example.tacom.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import androidx.recyclerview.widget.RecyclerView
import com.example.tacom.adapter.UserAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration

class UsersActivity : AppCompatActivity() {
    private var mDataBase: UserDao? = null

    private lateinit var addButton: Button
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var mUserRecycler: RecyclerView
    private lateinit var mUserAdapter: UserAdapter

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        addButton = findViewById(R.id.buttonAdd)
        firstName = findViewById(R.id.editTextTextPersonName)
        lastName = findViewById(R.id.editTextTextPersonName2)
        mUserRecycler = findViewById(R.id.userRecyclerView)

        initDatabase()

        addButton.setOnClickListener {
            if(firstName.text.isNullOrBlank()){
                Toast.makeText(this, "Nome em branco não permitido", Toast.LENGTH_LONG).show()
            }
            if(lastName.text.isNullOrBlank()){
                Toast.makeText(this, "Sobrenome em branco não permitido", Toast.LENGTH_LONG).show()
            } else {
                scope.launch {
                    mDataBase?.insertAll(User(
                        firstName = firstName.text.toString(),
                        lastName = lastName.text.toString()
                    ))
                }
            }
        }
    }

    private fun updateRecyclerView(users: List<User>) {
        mUserAdapter = UserAdapter(users)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this)
        mUserRecycler.layoutManager = layoutManager
        mUserRecycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mUserRecycler.adapter = mUserAdapter
    }

    private fun initDatabase() {
        scope.launch {
            mDataBase =  AppDatabase.invoke(this@UsersActivity).userDao()

            mDataBase?.loadUser()
                ?.catch { exception ->
                    Log.e(TAG,null, exception)
                }
                ?.collect {
                    runOnUiThread {
                        updateRecyclerView(it)
                    }
                }
        }
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    companion object {
        const val TAG = "UsersActivity"
    }
}