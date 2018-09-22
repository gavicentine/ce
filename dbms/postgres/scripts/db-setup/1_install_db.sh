echo "Make sure you have the directory " $4
echo "Creating CE Database. Wait..."
cd $4
export PGPASSWORD=$2
#sudo -i -u postgres
sudo -u postgres dropdb --username=$1 ce
sudo -u postgres createdb --username=$1 --owner=$1 --encoding=UTF8 --tablespace=pg_default ce
RES=`sudo -u postgres ./psql -d ce -U $1 -f $3//db-setup//2_create_tables.sql`
RES=`sudo -u postgres ./psql -d ce -U $1 -f $3//db-setup//3_functions.sql`
RES=`sudo -u postgres ./psql -d ce -U $1 -f $3//db-setup//4_triggers.sql`
RES=`sudo -u postgres ./psql -d ce -U $1 -f $3//db-setup//5_sequences.sql`
RES=`sudo -u postgres ./psql -d ce -U $1 -f $3//db-setup//10_base_data.sql`
PGPASSWORD=""
export PGPASSWORD
#exit
echo "CE Database has been created."