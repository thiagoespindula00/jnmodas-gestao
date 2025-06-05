set -e

psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE DATABASE jnmodas_gestao_produtos_db;
EOSQL