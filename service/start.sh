#gunicorn -w 3 -k gevent wsgi  -b 0.0.0.0:80

#gunicorn -w 2 -b 0.0.0.0:8080 wsgi:application
python manage.py runserver -h 0.0.0.0 -p 5000

