# Sistema de Nómina - Recursos Humanos

Proyecto para la **Hoja de Trabajo 2** (Bimestre 3, Semana 4) — Centro Educativo Técnico Laboral Kinal.

## Descripción

Aplicación de escritorio en JavaFX que gestiona el registro y cálculo de sueldos de empleados según su tipo de contrato, aplicando los principios de la Programación Orientada a Objetos: **herencia**, **polimorfismo**, **encapsulamiento** y **clases abstractas**.

El formulario de registro cambia dinámicamente según el tipo de empleado seleccionado, y el resumen final calcula el total a pagar recorriendo la lista de empleados y aplicando el método `calcularSueldo()` polimórfico de cada uno.

## Tecnologías

- Java
- JavaFX (SDK manual, sin FXML — interfaz construida 100% en código)
- CSS personalizado (tema oscuro inspirado en JetBrains)
- NetBeans

## Arquitectura (MVC)

- **`modelo`**: Clases de datos — `Empleado` (clase abstracta), `Asalariado`, `PorHoras`, `Comisionista`.
- **`view`**: `VistaPrincipalView` — construye únicamente los componentes visuales (formularios, tabla, botones).
- **`controller`**: `SceneManagerController` — Maneja la vista, maneja los eventos y contiene la lógica de negocio.
- **`system`**: `Principal` — clase de arranque de la aplicación (extiende `Application`).
- **`styles`**: `estilos.css` — hoja de estilos de la interfaz.

## Tipos de empleado soportados

| Tipo | Datos requeridos | Fórmula de cálculo |
|---|---|---|
| **Asalariado** | Sueldo fijo mensual | `sueldoFijoMensual` |
| **Por Horas** | Costo por hora, horas trabajadas | `costoHora * horasTrabajadas` |
| **Comisionista** | Ventas totales, porcentaje de comisión | `ventasTotales * (porcentajeComision / 100)` |

## Funcionalidades

- Formulario de registro con `ComboBox` dinámico: los campos cambian según el tipo de empleado elegido.
- Validación de datos con `try-catch` (campos numéricos inválidos) y validación manual (nombre vacío), mostrando alertas visuales al usuario.
- `TableView` con los empleados registrados, actualizado en tiempo real mediante `ObservableList`.
- Botón **Calcular Total**, que suma el sueldo de todos los empleados registrados usando polimorfismo.
- Interfaz con estilo visual personalizado (CSS).

## Cómo ejecutar

1. Abrir el proyecto en NetBeans.
2. Verificar que las VM Options del proyecto incluyan el `module-path` hacia el SDK de JavaFX:
   ```
   --module-path "RUTA_AL_SDK_JAVAFX\lib" --add-modules javafx.controls,javafx.fxml
   ```
3. Ejecutar la clase `Principal.java` (paquete `com.luiscastro.system`).

## Autor

Luis Castro — Cuarto Informática 2026
