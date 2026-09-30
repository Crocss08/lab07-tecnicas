# Tarea: Mi prompt avanzado

## Tarea elegida

Generar casos de prueba para el formulario de registro de usuarios de una pagina web (correo, contrasena y confirmacion de contrasena). Es una tarea util en mi carrera porque probar formularios es parte del desarrollo de software.

## Version 1: prompt basico

```text
Dame casos de prueba para un registro de usuarios.
```

- Tecnica agregada: ninguna (prompt basico).
- Que paso: la IA entrego una lista larga y general, con casos mezclados y sin un formato definido. No tomo en cuenta las reglas del formulario porque no se las di.

## Version 2: rol, contexto y prompt estructurado

```text
<rol>Actua como analista de pruebas de software con experiencia en formularios web.</rol>

<contexto>Formulario de registro con correo, contrasena y confirmacion de contrasena. La contrasena debe tener minimo 8 caracteres, una mayuscula y un numero. El correo no puede estar repetido.</contexto>

<tarea>Escribe 8 casos de prueba para este formulario.</tarea>

<formato>Tabla con las columnas: ID, escenario, datos de entrada, resultado esperado.</formato>
```

- Tecnicas agregadas: role prompting y prompt estructurado.
- Por que: el rol fija el punto de vista de un tester y las etiquetas separan las reglas del formulario, el pedido y el formato.
- Que mejoro: la respuesta llego en una tabla con las 4 columnas y los casos usaron las reglas de la contrasena. Aun asi, algunos casos eran obvios y faltaron casos limite.

## Version 3: prompt final

```text
<rol>Actua como analista de pruebas de software con experiencia en formularios web, que explica a un estudiante de segundo ciclo.</rol>

<contexto>Formulario de registro con correo, contrasena y confirmacion de contrasena. La contrasena debe tener minimo 8 caracteres, una mayuscula y un numero. El correo no puede estar repetido.</contexto>

<ejemplo>
| ID | Escenario | Datos de entrada | Resultado esperado |
| CP-01 | Registro correcto | correo: ana@mail.com, contrasena: Clave123, confirmacion: Clave123 | Cuenta creada |
</ejemplo>

<tarea>Piensa paso a paso que puede fallar en cada campo (vacios, formato, longitud, reglas de la contrasena, correo repetido) y luego escribe 10 casos de prueba con el mismo formato del ejemplo. Despues revisa tu tabla, agrega los casos limite que falten e indica cuales agregaste.</tarea>

<formato>Tabla con las columnas: ID, escenario, datos de entrada, resultado esperado. Al final, una lista corta con los casos agregados en la revision. Responde en espanol.</formato>
```

- Tecnicas agregadas: few-shot (una fila de ejemplo), chain of thought (pensar campo por campo) y autocritica (revisar y agregar casos).
- Por que: el ejemplo fija el formato exacto, el razonamiento por campos evita olvidar validaciones y la autocritica cubre los casos limite.
- Que mejoro: la tabla siguio el mismo formato del ejemplo, incluyo casos limite (campos vacios, correo sin @, contrasena de 7 caracteres, confirmacion distinta, correo repetido) y la IA indico cuales agrego.

## Tecnicas usadas en el prompt final

| Tecnica | Parte del prompt final |
| --- | --- |
| Role prompting | `<rol>`: analista de pruebas de software con experiencia en formularios web |
| Prompt estructurado | Etiquetas `<rol>`, `<contexto>`, `<ejemplo>`, `<tarea>` y `<formato>` |
| Few-shot | `<ejemplo>`: fila CP-01 con el formato esperado |
| Chain of thought | `<tarea>`: "Piensa paso a paso que puede fallar en cada campo" |
| Autocritica | `<tarea>`: "revisa tu tabla, agrega los casos limite que falten e indica cuales agregaste" |

## Evaluacion del resultado

| Criterio | Cumple (Si / No) |
| --- | --- |
| Usa las 4 columnas pedidas | Si |
| Sigue el mismo formato del ejemplo en todas las filas | Si |
| Incluye casos con campos vacios | Si |
| Incluye casos de contrasena que incumplen las reglas | Si |
| Incluye el caso de correo repetido | Si |
| Indica que casos agrego en la revision | Si |
| Hay casos repetidos o sin sentido | No |

## Por que elegi estas tecnicas

Elegi rol y prompt estructurado porque las reglas del formulario son varias y necesitaba que la IA no las mezclara con el pedido. Use few-shot porque queria que todas las filas tuvieran el mismo formato de tabla, y chain of thought porque probar un formulario exige pensar campo por campo que puede fallar. Agregue autocritica porque los casos limite son lo que mas suele faltar en una primera respuesta. No use descomposicion porque la tarea es pequena y se resuelve bien en un solo pedido; dividirla en varios mensajes habria sido mas lento sin mejorar el resultado.
