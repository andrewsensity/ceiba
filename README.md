# Prueba Ceiba
La aplicación es para la prueba técnica de Ceiba en tecnología Android.
Utiliza un conjunto de librerías Android Jetpack más Retrofit para obtener los datos desde la API REST, se usa Jetpack Compose como sistema de vistas.

## Definición funcional
Se crea una aplicación que hace consumo de una api Rest para obtener los datos de unos usuarios con sus respectivas publicaciones, se presenta una lista de usuarios mostrando la información básica que contiene nombre, teléfono y correo electrónico, realiza una navegacion a la vista de publicaciones al dar clic en el text "VER PUBLICACIONES" y muestra de nuevo la información básica pero ahora acompañada del listado de las publicaciones.

* Pantalla Main donde encontramos barra de búsqueda y listado de usuarios.
* Es posible realizar búsqueda escribiendo en la barra de búsqueda.
* Al realizar la búsqueda se lista los resultados con base en la palabra clave escrita por el usuario.
* Icono clickeable para borrar la búsqueda X.
* Al seleccionar algún item del resultado de la búsqueda navega a la pantalla de Publicaciones.
* La pantalla de Publicaciones contiene los publicaciones y los datos básicos del item seleccionado.
* Se permite la navegación hacia atrás desde la pantalla de publicaciones a la pantalla principal.

## Definiciones técnicas
* Se trabaja con arquitectura MVVM.
* Se inyecta dependencias con Dagger Hilt
* Se trabajan el sistema de vistas con Jetpack Compose.
* Se hace uso de Retrofit para obtener los datos desde las api.
* Se hace uso de Room para gurdar en base de datos local la información obtenida de la web.
* Se realizan pruebas unitarias de los servicios.

> El repositorio lo encuentras [aqui](https://github.com/andrewsensity/Ceiba).

## API
Las apis usadas: 
* [Api de usuarios](https://jsonplaceholder.typicode.com/users)
* [Api de publicaciones](https://jsonplaceholder.typicode.com/posts)
* [Api de publicaciones por id del usuario](https://jsonplaceholder.typicode.com/posts?userId=1)
* [Url base](https://jsonplaceholder.typicode.com/)

## Arquitectura
El proyecto utiliza el patrón de arquitectura MVVM.

## Librerias

* [El estado y Jetpack Compose](https://developer.android.com/jetpack/compose/state?hl=es-419) - El 
  estado de una app es cualquier valor que puede cambiar con el paso del tiempo. Esta es una 
  definición muy amplia y abarca desde una base de datos de Room hasta una variable de una clase.
* [Material3](https://developer.android.com/jetpack/androidx/releases/compose-material3) - la siguiente 
  evolución de Material Design. Material 3 incluye temas y componentes actualizados, y 
  funciones de personalización de Material You, como el color dinámico.
* [Navigation Component](https://developer.android.com/jetpack/compose/navigation)
    - Puedes navegar entre los elementos que admiten composición y aprovechar la infraestructura y las funciones del componente Navigation
* [Dagger Hilt](https://developer.android.com/jetpack/compose/libraries?hl=es-419) - For Dependency
  Injection.
* [Retrofit](https://square.github.io/retrofit/) - Para acceder a la API Rest
* [Room](https://developer.android.com/training/data-storage/room?hl=es-419) - Librería para el guardado en base de datos local de los datos requeridos
* [Mock Web Server](https://github.com/square/okhttp/tree/master/mockwebserver) - Un servidor web con capacidad de scripting para probar clientes HTTP