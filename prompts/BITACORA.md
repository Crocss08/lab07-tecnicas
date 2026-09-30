# Bitacora de tecnicas avanzadas

Laboratorio 07: Tecnicas Avanzadas de Prompting. Herramienta de IA usada: Claude (plan gratuito).

## Ejercicio 2: Zero-shot, one-shot y few-shot

Tarea: clasificar 5 comentarios de clientes como Positivo, Negativo o Neutral. Etiquetas correctas: Positivo, Negativo, Neutral, Negativo, Positivo.

| Tipo | Aciertos (de 5) | Formato de la respuesta | Todas con el mismo formato (Si/No) |
| ---- | --------------- | ----------------------- | ---------------------------------- |
| Zero-shot | 5 | Lista numerada con la etiqueta y una breve explicacion en cada comentario | No |
| One-shot | 5 | Lista con "comentario -> etiqueta", con alguna explicacion extra | Casi (una linea con formato distinto) |
| Few-shot | 5 | Una linea por comentario con el formato exacto "texto" -> etiqueta, sin explicaciones | Si |

Observacion: en los tres casos la IA acerto, pero solo con few-shot el formato fue siempre igual. Eso permite copiar muchas respuestas a Excel sin corregirlas una por una.

## Ejercicio 3: Chain of Thought

Calculo correcto: 120 x 0,75 = 90; 90 x 1,18 = 106,20; 106,20 x 3 = 318,60. Total correcto: S/ 318,60.

| Pedido | Respuesta de la IA | Muestra los pasos (Si/No) | Correcta (Si/No) |
| --- | --- | --- | --- |
| Directo | 318,60 | No | Si |
| Paso a paso | S/ 318,60 (con descuento, IGV y total por 3 unidades detallados) | Si | Si |

Aunque la respuesta directa fue correcta, ver los pasos me permite comprobar cada calculo con la calculadora. Si hubiera un error, sabria exactamente en que paso esta.

## Ejercicio 4: Role prompting

| Version | Vocabulario (sencillo/tecnico) | Usa ejemplos o codigo | A quien le sirve mas |
| --- | --- | --- | --- |
| A. Sin rol | Intermedio, definicion general | Un ejemplo corto de codigo | A cualquier lector en general |
| B. Rol docente | Sencillo | Comparacion con una caja con etiqueta, sin codigo o con muy poco | A quien nunca ha programado |
| C. Rol senior | Tecnico (tipo de dato, memoria, alcance) | Codigo Java con declaracion e inicializacion | A un companero desarrollador |

Observacion: el rol no agrega conocimientos, cambia el enfoque, el vocabulario y el nivel de detalle. Un rol vago como "experto" casi no cambia la respuesta.

## Ejercicio 5: Descomposicion

Pedido de una sola vez ("Crea un sistema de inventario para una tienda"): respuesta generica y muy larga, sin decisiones concretas sobre requisitos ni clases.

- Paso 1: la IA entrego 5 requisitos principales (registrar productos, controlar stock, registrar entradas y salidas, buscar productos, generar reporte de stock).
- Paso 2: la IA diseno las clases (por ejemplo Producto, Inventario y Movimiento) con sus atributos y tipos de dato.
- Paso 3: la IA escribio la clase Producto con atributos, constructor y metodos get y set, coherente con el diseno del paso 2.
- Paso 4: la IA propuso 3 mejoras: validar datos en los setters (precio y stock no negativos), agregar toString, equals y hashCode, y usar un tipo adecuado para el precio.
- Compilacion (opcional): javac Producto.java terminó sin errores y genero Producto.class.

Comparacion: el pedido por pasos fue mas ordenado y coherente, porque cada respuesta sirvio de contexto para la siguiente y pude revisar cada parte antes de continuar. El pedido de una sola vez fue mas general.

## Ejercicio 6: Prompt estructurado y autocritica

Prompt basico: "Dame casos de prueba para un login." Resultado: lista desordenada y general, sin formato definido.

Prompt estructurado y mensaje de autocritica usados:

```text
<rol>Actua como analista de pruebas de software.</rol>

<contexto>Login web con correo y contrasena. La cuenta se bloquea despues de 3 intentos fallidos.</contexto>

<tarea>Piensa paso a paso que puede fallar y escribe 6 casos de prueba.</tarea>

<formato>Tabla con las columnas: ID, escenario, datos de entrada, resultado esperado.</formato>

Autocritica (mismo chat):
Revisa tu tabla: faltan casos limite como campos vacios, correo sin @ o contrasena con espacios? Agrega los que falten e indica cuales agregaste.
```

Evaluacion de la tabla final:

| Que revisar | Cumple (Si / No) |
| --- | --- |
| Tiene las 4 columnas pedidas? | Si |
| Incluye el bloqueo despues de 3 intentos? | Si |
| Incluye casos con campos vacios? | Si |
| Indica que casos agrego en la autocritica? | Si |
| Hay algun caso repetido o que no tenga sentido? | No |

Observacion: la autocritica agrego casos limite que faltaban (correo vacio, correo sin @, contrasena con espacios). Aun asi, yo soy el ultimo revisor, porque la IA tambien puede equivocarse al revisarse a si misma.
