# TACOM_Challenge

Desafio técnico para Desenvolvedor Android 


# 1

  a. Criar um arquivo vazio de nome teste

  ```
    adb shell
    echo "" > /sdcard/teste.txt
  ```

  b. Exibir o conteúdo do arquivo

  ```
    adb shell
    cat PATH_TO_FILE
  ```

  c. Listar a última modificação do arquivo

  ```
    adb shell
    stat -c %y PATH_TO_FILE
  ```

  d. Acompanhar as atualizações do mesmo

  ```
  
  ```

  e.inserir conteúdo em arquivo

   ```
    adb pull {path_aquivo}
    cat nome_arquivo
    echo "conteudo" > nome_arquivo
   ```

  f.adicionar conteúdo em arquivo

   ```
   adb shell
   cd path_aquivo
   adb push {conteudo}
   ```

  g.fazer download do arquivo teste

   ```
   adb pull path_do_arquivo
   ```

  h.fazer upload do arquivo teste2 para o diretódio /mnt/Tacom

   ```
   adb push “C:\teste.txt” “/sdcard/mnt/Tacom”
   ```

  i.filtrar pelo logcat utilizando uma determinada tag

   ```
   adb logcat -s "tag"
   ```

  j.filtrar pelo logcat por determinado conteúdo

   ```
    adb logcat -v tag | grep -e “conteudo”
   ```

  k.apagar o arquivo teste

  ```
    adb shell 
    rm path_do_arquivo/test.txt
  ```

  l.criar um diretório MeuDiretorio

  ```
    adb shell 
    mkdir /sdcard/MeuDiretorio
  ```

  m.apagar o diretório MeuDiretorio

  ```
    adb shell 
    cd sdcard
    rmdir MeuDiretorio
  ```

  n.iniciar uma Activity através do terminal

  ```
    adb shell 
    am start -n com.example.tacom/com.example.test.MainActivity
  ```

  o.iniciar um Service através do terminal

  ```
    adb shell 
    am startservice com.example.tacom/.YourTacomService
  ```

  p.parar um Service através do terminal

  ```
    adb shell 
    am force-stop com.example.tacom
  ```

  q.instalar uma apk através do terminal`

   ```
    adb install example.apk
   ```

  r.desinstalar uma apk através do terminal

   ```
    adb uninstall app_package_name
   ```