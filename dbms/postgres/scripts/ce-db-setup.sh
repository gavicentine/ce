#echo off
echo "*************************************************************************"
echo "* This batch file sets up all necessary database artifacts for CE."
echo "* By default, it assumes potgres/postges as userid/pwd to log in to Postgres,"
echo "* /dbms/postgres/scripts/db-setup as the folder with the scripts and"
echo "* /usr/lib/postgresql/10/bin as the Postgres bin folder."
echo "* You can change the default data by editing this file."
echo "*************************************************************************"
echo "Press enter to continue"; read line

./db-setup/1_install_db.sh postgres postges ~/dvl/projetos/ce/dbms/postgres/scripts /usr/lib/postgresql/10/bin
