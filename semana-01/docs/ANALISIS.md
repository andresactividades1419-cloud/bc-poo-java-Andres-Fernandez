# Análisis Orientado a Objetos - Diagnóstico Plus

## 1. Identificación del Dominio

**Nombre del negocio:** Diagnóstico Plus  
**Tipo:** Laboratorio Clínico y de Análisis  
**Ubicación:** Bogotá, Localidad de Chapinero  
**Descripción:** Diagnóstico Plus es un laboratorio clínico que ofrece servicios de análisis médicos, exámenes de sangre, orina, microbiología y pruebas especializadas. Cuenta con 10 bacteriólogos y atiende aproximadamente 150 pacientes diarios. El laboratorio se especializa en análisis clínicos con atención personalizada y resultados rápidos y confiables.

---

## 2. Objetos Identificados

### Objeto Principal: Paciente

**¿Qué es?:** Un paciente es una persona que solicita y recibe servicios de análisis clínicos en el laboratorio. Es la entidad central del negocio, ya que todos los procesos giran en torno a la atención y el análisis de muestras de los pacientes.

**Atributos identificados:**
- `numeroIdentificacion`: String - Cédula o documento único del paciente para identificación
- `nombreCompleto`: String - Nombre completo del paciente para registros médicos
- `edad`: int - Edad del paciente, importante para análisis de referencia de valores
- `telefono`: String - Contacto del paciente para notificaciones de resultados
- `tienePlanSalud`: boolean - Indica si el paciente tiene plan de salud para aplicar descuentos
- `tipoSangre`: String - Grupo sanguíneo (O+, A+, B+, AB+, etc.), dato médico fundamental
- `saldoPendiente`: double - Monto pendiente de pago por exámenes realizados

**Métodos identificados:**
- `mostrarInformacion()`: Despliega toda la información del paciente de forma organizada
- `calcularDescuentoPlanSalud()`: Calcula el descuento del 20% si tiene plan de salud activo
- `agregarExamen(double)`: Registra un nuevo examen y actualiza el saldo pendiente
- `realizarPago(double)`: Procesa el pago de exámenes y actualiza el saldo
- `esAdultoMayor()`: Verifica si el paciente tiene 60 años o más (importante para prioridad de atención)
- `getters/setters`: Métodos de acceso y modificación de atributos

---

### Objeto Secundario: Bacteriologo

**¿Qué es?:** Un bacteriólogo es el profesional de la salud responsable de realizar los análisis clínicos, tomar muestras y procesar los exámenes. Es la entidad que ejecuta los servicios del laboratorio.

**Atributos identificados:**
- `codigoBacteriologo`: String - Identificador único del bacteriólogo en el sistema
- `nombreCompleto`: String - Nombre completo del profesional
- `especialidad`: String - Área de especialización (Hematología, Microbiología, etc.)
- `pacientesAtendidos`: int - Contador de pacientes atendidos en el día
- `disponible`: boolean - Estado de disponibilidad para atender pacientes
- `aniosExperiencia`: int - Años de experiencia profesional, influye en tarifas

**Métodos identificados:**
- `mostrarDatos()`: Muestra la información del bacteriólogo
- `atenderPaciente(String)`: Registra la atención de un paciente y actualiza el contador
- `esSenior()`: Determina si es bacteriólogo senior (10+ años de experiencia)
- `calcularTarifaPorExamen()`: Calcula la tarifa según experiencia (tarifa base + incremento por años)
- `reiniciarContadorDiario()`: Reinicia el contador de pacientes al final del día
- `setDisponible(boolean)`: Actualiza el estado de disponibilidad del bacteriólogo

---

## 3. Relación entre Objetos

**Tipo de relación:** Asociación (Un Bacteriólogo atiende a múltiples Pacientes)

**Descripción:**

En el contexto del laboratorio Diagnóstico Plus, existe una relación de atención entre Bacteriólogo y Paciente. Un bacteriólogo puede atender a múltiples pacientes durante su jornada laboral, y cada paciente puede ser atendido por diferentes bacteriólogos según su especialidad y disponibilidad.

**Ejemplos de interacción:**
- Un Bacteriólogo especializado en Hematología atiende a un Paciente que necesita un hemograma completo
- El Bacteriólogo registra al Paciente en su contador de pacientes atendidos
- El Paciente se le asigna un examen que aumenta su saldo pendiente
- El Bacteriólogo cobra una tarifa que depende de su experiencia profesional

Esta relación es fundamental porque representa el flujo principal del negocio: el profesional (Bacteriólogo) presta el servicio al cliente (Paciente).

---

## 4. Justificación del Diseño

### ¿Por qué elegí estos objetos?

Elegí **Paciente** como objeto principal porque es la entidad central del negocio. Todo el laboratorio existe para atender pacientes, procesar sus muestras y entregar resultados. Sin pacientes, no hay laboratorio.

Elegí **Bacteriologo** como objeto secundario porque representa el recurso humano especializado que ejecuta los servicios. Los bacteriólogos son quienes realizan los análisis, toman muestras y generan los resultados. Son el "motor" operativo del laboratorio.

### ¿Por qué estos atributos son importantes?

**Para Paciente:**
- `numeroIdentificacion`: Esencial para identificar de forma única a cada paciente y su historial
- `nombreCompleto`: Necesario para registros legales y comunicación
- `edad`: Crítico porque los valores de referencia en análisis clínicos varían según la edad
- `telefono`: Fundamental para contactar al paciente con los resultados
- `tienePlanSalud`: Determina descuentos y forma de facturación
- `tipoSangre`: Información médica básica que puede ser requerida en múltiples exámenes
- `saldoPendiente`: Control financiero de los servicios prestados

**Para Bacteriologo:**
- `codigoBacteriologo`: Identificador para asignación de tareas y control de personal
- `nombreCompleto`: Identificación del profesional responsable
- `especialidad`: Permite asignar pacientes según el tipo de examen requerido
- `pacientesAtendidos`: Métrica de productividad y control de carga laboral
- `disponible`: Gestión en tiempo real de la capacidad de atención
- `aniosExperiencia`: Influye en tarifas y confiabilidad de resultados

### ¿Por qué estos métodos son necesarios?

Los métodos implementados responden a la **lógica de negocio real** del laboratorio:

1. **Visualización de información**: Necesario para interfaces de usuario, reportes e identificación rápida
2. **Cálculos financieros**: El laboratorio necesita calcular descuentos, tarifas y pagos
3. **Gestión de estados**: Control de disponibilidad, planes de salud, contadores diarios
4. **Validaciones**: Verificar adultos mayores (prioridad), niveles senior (tarifas)
5. **Transacciones**: Agregar exámenes, realizar pagos, atender pacientes

Estos métodos simulan las operaciones diarias que realmente ocurren en un laboratorio clínico.

---

## 5. Comparación: POO vs Programación Estructurada

### Sin POO (Estructurado):

En programación estructurada tradicional, tendríamos que manejar los datos del paciente y bacteriólogo usando arrays o variables separadas:
```java
// Variables separadas para cada paciente
String[] idsPacientes = new String[150];
String[] nombresPacientes = new String[150];
int[] edadesPacientes = new int[150];
boolean[] planesSalud = new boolean[150];
double[] saldos = new double[150];

// Variables separadas para cada bacteriólogo
String[] codigosBact = new String[10];
String[] nombresBact = new String[10];
int[] pacientesAtendidos = new int[10];

// Funciones separadas
void mostrarPaciente(int indice) { ... }
double calcularDescuento(int indice) { ... }
void atenderPaciente(int indiceBact, int indicePac) { ... }
```

**Problemas:**
- Los datos están dispersos y no hay relación clara entre ellos
- Difícil mantener la consistencia (¿qué pasa si modifico un array pero olvido otro?)
- Código difícil de escalar (agregar un nuevo atributo requiere modificar múltiples partes)
- No hay encapsulación de datos

### Con POO:
```java
Paciente paciente1 = new Paciente("123", "María", 45, "32012345", "O+");
Bacteriologo bact1 = new Bacteriologo("BACT001", "Dra. Laura", "Hematología", 12);

paciente1.agregarExamen(150000);
bact1.atenderPaciente(paciente1.getNombreCompleto());
```

**Ventajas:**
- Los datos están agrupados lógicamente con sus comportamientos
- Fácil de mantener y extender
- Código más legible y cercano al dominio real
- Encapsulación protege la integridad de los datos

### Ventajas específicas en mi dominio:

1. **Modelado Natural**: Las clases Paciente y Bacteriologo representan directamente entidades del mundo real del laboratorio, haciendo el código intuitivo

2. **Mantenibilidad**: Si necesito agregar un nuevo tipo de examen o campo al paciente, solo modifico la clase Paciente sin afectar otras partes del sistema

3. **Reutilización**: Puedo crear múltiples instancias de Paciente con diferentes datos sin duplicar código. Cada objeto mantiene su propio estado independiente

4. **Encapsulación**: Los datos sensibles (saldo, identificación) están protegidos y solo se acceden mediante métodos controlados, evitando modificaciones incorrectas

5. **Escalabilidad**: Puedo agregar fácilmente más clases (Examen, Muestra, Resultado) y relacionarlas mediante herencia, interfaces o composición sin reestructurar todo el código

---

## 6. Diagrama de Clases
```
┌─────────────────────────────┐         ┌──────────────────────────────┐
│       Paciente              │         │      Bacteriologo            │
├─────────────────────────────┤         ├──────────────────────────────┤
│ - numeroIdentificacion      │         │ - codigoBacteriologo         │
│ - nombreCompleto            │         │ - nombreCompleto             │
│ - edad                      │         │ - especialidad               │
│ - telefono                  │         │ - pacientesAtendidos         │
│ - tienePlanSalud            │  atiende│ - disponible                 │
│ - tipoSangre                │ ◄───────│ - aniosExperiencia           │
│ - saldoPendiente            │         │                              │
├─────────────────────────────┤         ├──────────────────────────────┤
│ + mostrarInformacion()      │         │ + mostrarDatos()             │
│ + calcularDescuentoPlan()   │         │ + atenderPaciente(String)    │
│ + agregarExamen(double)     │         │ + esSenior()                 │
│ + realizarPago(double)      │         │ + calcularTarifaPorExamen()  │
│ + esAdultoMayor()           │         │ + reiniciarContadorDiario()  │
│ + getters/setters           │         │ + getters/setters            │
└─────────────────────────────┘         └──────────────────────────────┘
```

**Relación:** Un Bacteriólogo atiende a múltiples Pacientes durante su jornada laboral.

---

## 7. Posibles Extensiones Futuras

Para las siguientes semanas, este diseño puede evolucionar hacia:

1. **Herencia**: Crear subclases como `PacienteUrgente`, `PacienteVIP`, `BacteriologoSenior`
2. **Composición**: Agregar clases `Examen`, `Muestra`, `Resultado` que se relacionen con Paciente
3. **Interfaces**: Implementar `Facturable` para Paciente, `Certificable` para Bacteriologo
4. **Colecciones**: Usar `ArrayList<Paciente>` para gestionar múltiples pacientes de forma dinámica
5. **Excepciones**: Manejo robusto de errores en pagos, validaciones de datos, etc.



