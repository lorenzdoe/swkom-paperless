
## start db
```bash 
docker run --name paperlessdb -e POSTGRES_USER=paperless -e POSTGRES_PASSWORD=pwd123456 -e POSTGRES_DB=swkom -p 5432:5432 postgres 
```

### reverse engineer database using jpabuddy

https://jpa-buddy.com/documentation/reverse-engineering/

install intellij jpa buddy plugin

configure database connection to intellij

from 'jpa structure' panel on the left side, select 'jpa entities from db' and select the connection

in case the 'jpa structure' panel is not visible, add hibernate dependency to project and restart intellij

select all tables and references