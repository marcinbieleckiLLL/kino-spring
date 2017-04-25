# kino-spring

Projekt został napisany z wykorzystaniem narzędzi takich jak: Spring Tool Suite, apache tomcat, maven oraz baz danych MySql. Aby uruchomić projekt należy, pobrać go z repozytorium, zainstalować i skonfigurować powyższe składniki. Następnie należy zaimportować projekt do eclipsa. W tym celu wybrać: File->Import->Maven->Existing Maven Project. W miejscu root directory należy wskazać ścieżke do pliku pom.xml (czyli głowny folder projektu). W celu skonfigurowania połączenia z bazą danych należy założyć własną bazę danych (np. korzystając z MySql Workbench) następnie w tym samym programie stworzyć poleceniem create schema schemat o nazwie "marcin". Nastepnie w projekcie zmienić konfigurację połączenia z bazą. W tym celu w pliku DispatcherServlet-context.xml oraz security-context.xml edytować bean o id "dataSource". Należy zmienić hasło oraz login na własny, podany przy tworzeniu bazy (można tam również zmienić nazwę "marcin" na inną).


Projekt to aplikacja webowa umozliwiająca kupno biletów do kina. Aby kupić bilet użytkownik musi się zalogować, po czym wybrać insteresujący go seans oraz miejsca.    
