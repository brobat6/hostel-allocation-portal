- [Creating and accessing virtual environment](#creating-and-accessing-virtual-environment)
  - [Packages needed](#packages-needed)
  - [Start Project](#start-project)

# Creating and accessing virtual environment

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

