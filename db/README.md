
## start db
```bash 
docker run --name paperlessdb -e POSTGRES_USER=paperless -e POSTGRES_PASSWORD=pwd123456 -e POSTGRES_DB=swkom -p 5432:5432 postgres 
```

or (since postgres is now in docker compose)

if there are issues, simply comment out the content in postgres Dockerfile (db package/folder) as well as postgres things from DockerCompose file

```bash
docker compose up --build
```
once built, we can only let the db running, for working/debugging purposes backend and frontend can be started from intellij/vscode
important note - maven package works only with a running db

### reverse engineer database using jpabuddy

https://jpa-buddy.com/documentation/reverse-engineering/

install intellij jpa buddy plugin

configure database connection to intellij

from 'jpa structure' panel on the left side, select 'jpa entities from db' and select the connection

in case the 'jpa structure' panel is not visible, add hibernate dependency to project and restart intellij

select all tables and references