🍽️ Problema de los Cinco Alumnos (Filósofos)
📌 Descripción

Este proyecto implementa una versión del clásico problema de concurrencia conocido como “los filósofos comensales”, adaptado como cinco alumnos que comparten tenedores para comer.

Cada alumno es un hilo independiente que alterna entre pensar (esperar) y comer, utilizando recursos compartidos (tenedores). El sistema está diseñado para evitar deadlocks mediante una estrategia de orden en la toma de recursos.

⚙️ Funcionamiento
Hay 5 alumnos (hilos) sentados alrededor de una mesa.
Cada alumno necesita 2 tenedores (izquierdo y derecho) para comer.
Los tenedores son recursos compartidos entre alumnos vecinos.
Se utiliza sincronización para evitar conflictos.
Se evita el deadlock cambiando el orden de acceso a los tenedores:
Alumnos pares → primero izquierdo
Alumnos impares → primero derecho
🧩 Estructura del proyecto
📁 Clases principales
Main
Inicializa los alumnos y tenedores
Lanza los hilos
Espera a que todos terminen
👉
Alumno
Representa un hilo
Alterna entre esperar y comer
Implementa la lógica para evitar deadlock
👉
Tenedor
Recurso compartido
Controla el acceso mediante synchronized, wait() y notifyAll()
👉
🔄 Concurrencia

Este proyecto utiliza:

Threads (Thread)
Sincronización (synchronized)
Comunicación entre hilos (wait() / notifyAll())
🔒 Problemas abordados
❌ Condiciones de carrera
❌ Deadlock (bloqueo mutuo)
✔️ Coordinación entre hilos
▶️ Ejecución
Compilar:
javac alumnos/*.java
Ejecutar:
java alumnos.Main
📊 Ejemplo de salida
=== Cinco alumnos se sientan a comer ===

Alumno 0 esta esperando para comer...
Alumno 1 esta esperando para comer...

Alumno 0 coge el tenedor 0
Alumno 0 coge el tenedor 1
>>> Alumno 0 COMIENDO arroz <<<

Alumno 1 espera el tenedor 1
...
🎯 Objetivos del proyecto
Comprender problemas clásicos de concurrencia
Aprender a evitar deadlocks
Practicar sincronización en Java
Gestionar recursos compartidos
🚀 Posibles mejoras
Añadir interfaz gráfica (Swing / JavaFX)
Visualización en tiempo real del estado
Estadísticas de uso de tenedores
Implementar otras soluciones (ej. semáforos)
