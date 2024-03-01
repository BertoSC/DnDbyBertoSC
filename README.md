¿Cuáles son las estrategias?

La estrategia es la infertace AtaqueTipo que, a posteriori, es implementada por las clases de AtaqueEspada, AtaqueArco y AtaqueCuchillo, que son las estrategias concretas.

¿Está el código de los diferentes ataques mezclado?¿El código del ataque con espada es independiente del código del ataque con arco? .Relaciona esto con algún principio SOLID.

Cada uno de los códigos de ataque es independiente del resto. Eso quiere decir que, en cualquier momento, se podría enriquecer el programa con nuevos tipos de ataque que implementen la interfaz y, aún así, funcionar igual sin tocar que modificar la clase Personaje. Todo ello cumple el principio de inversión de dependencias, que en este caso se cumple gracias a la abstracción.

¿Para que vale la interface Ataque?

La interface Ataque ofrece una base de desarrollo de subclases que aplican un tipo de ataque diferente para ser usada por la clase Personaje. Es decir, cada subclase es un tipo de ataque con arma que puede ser utilizada e intercambiada en cualquier momento por cualquiera de los personajes que forman parte del programa. 

¿Qué clase o clase se encarga del papel de contexto?

El contexto es la clase Personaje, cuenta con métodos específicos para asignar y utilizar las diferentes estrategias y sirve como intermediaria entre la estrategia y la clase que contiene el main.

¿En que se parece y en que se diferencia el contexto de tu proyecto al contexto del Patrón teórico del boletín?

El parecido radica en que cuenta con funciones similares para lanzar estrategias, implementar estrategias, etc, pero el de mi proyecto cuenta con mayor complejidad y fue necesario separar cada subclase en un archivo diferente, debido a que en Java solo puede haber una clase pública en cada uno. 

¿Quién es el Cliente?

El cliente es la clase DDApp, que contiene el main y utiliza toda la estructura conformada por la interface y la clase Personaje. 

¿Como cambia el cliente de estrategia?

Para cambiar de estrategia, el cliente utiliza el método setAtaque de la clase Personaje. 

¿Para cambiar de estrategia, tiene que conocer el cliente detalles de implementación de la estrategia?

El cliente necesita conocer únicamente la existencia del método específico para asignar un tipo de estrategia y de los tipos de estrategias que hay disponibles debido a que la clase DDApp es la que gestiona los arrays de los ejércitos y los métodos que inicializan y arman ambos grupos de ataque, por lo que es la encargada de invocar a la estrategia sirviéndose de la clase Personaje y de sus métodos como intermediaria. 

¿Si creamos un nuevo tipo de ataque para un nuevo cliente, por ejemplo App2, es necesario modificar el cliente antiguo? Relaciona esto con algún principio SOLID.

Crear una nueva implementación de la interfaz no exige en ningún momento tener que modificar el cliente en el caso de que esa nueva implementación se utilice en otra nueva clase cliente, lo que cumple el principio de abierto-cerrado. Es decir, que el código está abierto para su expansión pero no para su modificación de forma obligatoria. En todo caso, sí que sería necesaria su alteración en caso de que quisiera hacer uso de esa nueva estrategia (por ejemplo, para añadir esa posibilidad en los métodos de asignación aleatoria de estrategias al array del ejército troll).
