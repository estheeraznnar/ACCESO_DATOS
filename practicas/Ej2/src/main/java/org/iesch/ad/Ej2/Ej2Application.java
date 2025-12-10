package org.iesch.ad.Ej2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Como en todos los blogs se pueden crear entradas o post, y los post podran ser comentadas
por los usuarios por lo que es necesario guardar al menos la siguiente informacion en bbdd.

Los endpoints de los usuarios deben estar con /api y los de desarrolladores /admin

2.1 Crear la estructura necesaria para que exisra presencia en el proyecto
creear la base de datos al arrancar.

Como no vamos a implementar la gestion de usuarios ni la gestion de perfiles, lo unico que podemos hacer
es esperar los endpoints destinados a los usuarios de los endpoint destinados a administradoser, no deben estar en api sino en admin

2.2 Creacion de un nuevo post
Los administradores podran crear post, enviando a nuestro endpoint un json, dicho json debe contener
 st creador, st contenido, str img
no se envia la fecha, la app debe gestionarle e introducirla de forma correcta

2.3 Un administrador podra borrar un post para ello debera pasar por url el id del posr a borrrar.
Por supuesto se debe borrar tanto el post como los comentarios asociados al mismo /borrarPost/id

2.4 Edicion de un post
Un administrador puede actualizar un post,para ello enviara un json con los mismos campos que al crear un post es decir. contenido, creador, rutaimagen
y pasara el id del posr a actualizar como parte de la url

si se actualiza un post para poder certificarlo como "funciona correctamente". Tambien se debe actualizar la fecha del post
/updatePost/id

2.5 Obtener todas las entradas o post existentes
El presente endpoin devolvera todos los endpoints existentes,poero con una consideracion, el campo contenido debe ser acortado a una longitud de 60 caracteres

2.6 Obtener un post en concreto
desarrollar un endpoint que pasando un id por laurl nos devuelva todos los datos de dicho post en un json(cont completo y comentarios asociados al mismo)
creador y comentario.
no se envia la fecha, la app debe gestionar e introducirla de forma correcta

Antes de guardar el coment, debo asegurarme que el coment no contiene ninguna de las palabras prohibidas del archivo, independientemente de que se encuentre en may
o en min. Si contiene alguna palabra prohibida, elendpoind nosdevolvera un json con el contenido "El comentario se publico por uso de lenguaje mal sonante"
en el campo comentario del json.
Piensa como gestionar el fichero, ya que hay muchas formas piensa como tratarlo de manera eficiente, con el menor consumo de CPU, este item es importante y secalificara.
No inventes, no metas en bbdd palabras, debes de trabajar con el fichero.

2.8 Error en el id de post
Cuando se pasa por url un id de post existente la aplicacion nos debe devolver una excepcion. O lo que es lo mismo, cuando busquemos un post y
no se encuentre devolveremos una excepcion. La excepcion debe tener formato estandar de Spring.
*/
@SpringBootApplication
public class Ej2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej2Application.class, args);
	}

}
