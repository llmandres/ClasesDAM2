# Funciones Lambda
Las funciones lambdas(a veces tambien llamadas "closures") es un t�rmino adoptado de la programaci�n funcional y corresponden con funciones de Java que normalmente son an�nimas y se escriben en l�nea all� donde se usan. Como cualquier funci�n recibe cero o m�s argumentos y devuelven uno o ning�n valor de retorno. Como cualquier funci�n, puede consumir m�todos de otras clases y objetos. Al declararse al mismo tiempo en donde se usan, puede acceder a las variables locales del �mbito al que pertenece, pero s�lo podr� usar estos como valores de s�lo lectura, impidiendo realizar alguna modificaci�n.

Las funciones lambdas se crearon a partir de la versi�n Java 8, por lo que no es posible usar su sintaxis en versiones anteriores. Sus entidades principales est�n contenidas en el package java.util.funcional. S� hay que decir, que no aportan una funcionalidad que no pueda hacerse con Java pre 8, simplemente es una manera m�s compacta de escribir c�digo Java. Se puede decir de manera resumida que una funci�n lambda es como una clase con un �nico m�todo p�blico. As� que los que no dispongan de Java 8 podr�an simular un comportamiento similar creando clases parecidas a las proporcionadas con el API de Java en el package java.util.functional. Es decir, podemos simular las funciones lambda, creado una clase anonima a partir de una interfaz funcional, o que solo tenga un metodo abstracto.


## Sintaxis
Una expresion lambda se compone de:
   
1. Listado de parametros separados por comas y encerrados en parentesis: <b>(int a, int b)</b>
2. El simbolo de flecha hacia la derecha: <b>-></b>
3. Un cuerpo que puede ser un bloque de codigo encerrado entre llaves o una sola expresion: <b>	a + b</b>
	
	Ej: (a, b) ->  a + b

## Entidades de java.util.functional
Antes de crear una funci�n de tipo lambda, conviene conocer las entidades b�sicas que componen esta manera de programar. Las principales entidades son interfaces con un �nico m�todo que debe implementar el programador y que estas implementaciones pueden hacerse llegar como argumentos de m�todos de otras muchas clases del API de Java. Hubo una gran modificaci�n de las clases existentes para aceptar este tipo de implementaciones all� donde tuviera sentido, como ocurre en las colecciones.

Las implementaciones de estas interfaces son del tipo, consume un valor y retorna otro tipo de valor, o produce un valor sin argumentos o produce un valor dados dos argumentos. A �stas se les llama unidades funcionales porque componen una l�gica interna que a priori el consumidor de esta l�gica no conoce, pero de la que s� se conoce su interfaz y por tanto la manera de relacionarse con el resto de los objetos, o lo que es lo mismo la manera de ser invocada. Aparece de nuevo el concepto de cajas negras en donde entran par�metros y salen resultados.

Las interfaces funcionales que nos proporciona java son parametrizables, es decir, los argumentos de entrada y de salida los podemos elegir nostros (el ejemplo m�s claro sobre clase parametrizable puede ser la clase ArrayList). Las interfaces funcionales m�s importantes contenidas en java.util.functional son:

1. <b>Supplier<T>:</b> No tenemos parametros de entrada pero si tenemos un parametro de salida. Esta funci�n se debe utilizar cuando se necesiten generar objetos sin requerir argumentos. El metodo asociado de la interfaz ser�a get(). 
2. <b>Consumer<T>:</b> Tenemos un parametro de entrada pero no tenemos parametro de salida. Esta en cambio es el opuesto de Supplier ya que consume, acepta como argumento el tipo T sin devolver ning�n valor de retorno. El metodo asociado de la interfaz ser�a accept().
3. <b>Function<T,R>:</b> Esta interfaz permite definir una funci�n que acepta un par�metro de tipo T y devuelve un resultado del tipo R, pudiendo aplicarle alguna transformaci�n u operaci�n. El metodo asociado de la interfaz ser�a apply().
4. <b>BiFunction<T,R,S>:</b> esta interfaz permite definir una funci�n que acepta dos par�metros de tipo T y R, devolviendo un resultado del tipo S. Normalmente ser�n operaciones de agregaci�n u operadores binarios como la suma, resta, etc. El metodo asociado de la interfaz ser�a apply().
5. <b>Predicate<T>:</b> La interfaz predicado debe devolver forzosamente un boolean dado un objeto de tipo T, normalmente utilizado para filtrar elementos de una colecci�n. El metodo asociado de la interfaz ser�a test().



 	