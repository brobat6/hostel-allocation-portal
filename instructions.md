- [Django + MySQL](#django--mysql)
  - [Packages needed](#packages-needed)
  - [Start Project](#start-project)
  - [Run Project](#run-project)
  - [Install Database API Driver](#install-database-api-driver)
  - [MySQL Config](#mysql-config)
  - [Concurrency - Possible Approach](#concurrency---possible-approach)
  - [Run Database migrations](#run-database-migrations)
- [Node.js + MySQL](#nodejs--mysql)

# Django + MySQL

Create virtual environment: 
In terminal - 
```py
virtualenv hostel_alloc_env
```

Access virtual environment:
In VSCode Terminal (Powershell) - 
```py
hostel_alloc_env/Scripts/activate.ps1
```
If "running scripts is disabled" error pops up - 
Open Windows PowerShell with the "Run as admin" option, then enter - 
```py
Set-ExecutionPolicy RemoteSigned
```

## Packages needed 

```
pip install django
```

## Start Project

```
django-admin startproject hostel_allocation_portal
```

## Run Project

```
python manage.py runserver
```
Then --> open with [localhost](http://localhost:8000/)

## Install Database API Driver

```
pip install mysqlclient
```

## MySQL Config

In settings.py, change DATABASE -> DEFAULT -> Engine to 'django.db.backends.mysql'
Additionally, change NAME, and add USER, PASSWORD, HOST

NOTE --> USER, PASSWORD could be set up as system variables/keys

The DATABASES dict should look like this - 
```py
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': 'campus',
        'USER': 'brobat',
        'PASSWORD': 'inazuma',
        'HOST': '127.0.0.1',
        'PORT': '3007'
    }
}
```

## Concurrency - Possible Approach

From Documentation : 

ATOMIC_REQUESTS 
Default: False

Set this to True to wrap each view in a transaction on this database. See Tying transactions to HTTP requests.

## Run Database migrations

```
python manage.py migrate
```



# Node.js + MySQL

In terminal - 
```
npm install mysql2
```

Node script to link - 
```js
var mysql = require('mysql2');

var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "barbara",
    port : 3007,
    database : 'lol'
});

con.connect(function(err) {
    if(err) throw err;
    console.log("Connected!");
});
```