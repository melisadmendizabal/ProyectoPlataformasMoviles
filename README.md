Descripción: 
FreeToFeel es una aplicación móvil relacionada al cuidado y seguimiento de la salud mental de los usuarios. En esta, se dan consejos diarios generales, así como consejos específicos para categorías que vaya seleccionando el usuario al momento de utilizar la app. De la misma manera, el usuario hace cuidado de ciertas mascotas que tienen problemas humanos reales, que cualquiera podría experimentar; así, se le fomenta al usuario una manera resolutiva de problemas, por los cuales podría estar pasando.  
Se considera que es una aplicación necesaria, debido a las constantes emociones percibidas por todas las personas, en todos los contextos y momentos. Estas emociones, así como ciertas situaciones incontrolables en la vida de las personas, pueden llegar a afectar la salud mental. 

Servicios: 
Se usará la API y software de base de datos “Supabase” para la autentificación de los usuarios (creación de cuentas/inicio de sesión), así como para guardar en la nube sus entradas de estados de ánimo, o de datos personales. De esta manera, todo lo relacionado exactamente con cada usuario será manejado por medio de este servicio. 
En cuanto a los consejos diarios/generales, así como los relacionados directamente con un estado de ánimo en concreto, serán guardados y manejados de manera local. Esto debido a que, independientemente de qué usuario esté usando la app, estos consejos estarán disponibles para cualquier persona que tenga la aplicación; por tanto, no depende del usuario, sino es inherente de la app. Por tanto, el equipo de trabajo será el encargado de crear todos estos recursos a utilizar. 

Librerías: 
Se usarán las librerías necesarias que requiera el uso del servicio de “Supabase” (hasta el momento se investigó que, como mínimo, se necesita: “ktor”, “supabase” y “viewmodel”). Con esto, se podrá hacer llamadas a internet para la autentificación del usuario, así como para acceder a sus inputs. 
De manera local, se usará Room para los consejos y/o cualquier otro dato local que sea necesario almacenar en una base de datos (local).
