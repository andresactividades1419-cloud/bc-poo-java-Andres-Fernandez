# Semana 01 - Introducción al Paradigma Orientado a Objetos

## 📝 Descripción

Implementación de las clases fundamentales del dominio **Diagnóstico Plus** (Laboratorio Clínico), aplicando los conceptos básicos de Programación Orientada a Objetos: clases, objetos, atributos y métodos.

**Dominio:** Laboratorio Clínico y de Análisis  
**Negocio:** Diagnóstico Plus  
**Ubicación:** Bogotá, Localidad de Chapinero

---

## 🎯 Objetivos Cumplidos

- [x] Implementar clase principal del dominio: `Paciente`
- [x] Implementar clase secundaria relacionada: `Bacteriologo`
- [x] Crear programa de demostración funcional: `Main.java`
- [x] Documentar análisis del dominio: `ANALISIS.md`
- [x] Aplicar convenciones de nomenclatura Java
- [x] Implementar mínimo 5 atributos en clase principal
- [x] Implementar mínimo 4 métodos en clase principal
- [x] Implementar mínimo 4 atributos en clase secundaria
- [x] Implementar mínimo 3 métodos en clase secundaria

---

## 📂 Archivos Entregados

### Código Fuente (src/)
- **`Paciente.java`** - Clase principal que representa a un paciente del laboratorio
    - 7 atributos (String, int, boolean, double)
    - 10+ métodos (incluye cálculos, validaciones, getters/setters)
    - Gestiona información médica y financiera del paciente

- **`Bacteriologo.java`** - Clase secundaria que representa al profesional del laboratorio
    - 6 atributos (String, int, boolean)
    - 8+ métodos (atención de pacientes, cálculo de tarifas)
    - Gestiona disponibilidad y experiencia profesional

- **`Main.java`** - Programa de demostración del sistema
    - Crea múltiples instancias de ambas clases
    - Demuestra todas las funcionalidades implementadas
    - Simula operaciones reales del laboratorio

### Documentación (docs/)
- **`ANALISIS.md`** - Análisis completo del dominio
    - Identificación de objetos del mundo real
    - Justificación de atributos y métodos
    - Comparación POO vs Programación Estructurada
    - Diagrama de clases
    - Posibles extensiones futuras

---

## 🚀 Instrucciones de Ejecución

### Opción 1: Desde IntelliJ IDEA

1. Abre el archivo `Main.java`
2. Haz clic en el botón verde ▶️ junto a `public static void main`
3. Selecciona **"Run 'Main.main()'"**

### Opción 2: Compilación Manual por Terminal
```bash
# Navegar a la carpeta de código fuente
cd semana-01/src

# Compilar todos los archivos Java
javac Paciente.java Bacteriologo.java Main.java

# Ejecutar el programa principal
java Main
```

### Requisitos
- Java Development Kit (JDK) 8 o superior
- No requiere librerías externas

---

## 📊 Salida Esperada

Al ejecutar el programa, verás una salida similar a:
```
╔═══════════════════════════════════════════════════════╗
║     LABORATORIO CLÍNICO DIAGNÓSTICO PLUS              ║
║     Bogotá - Localidad de Chapinero                   ║
║     Sistema de Gestión de Pacientes y Bacteriólogos   ║
╚═══════════════════════════════════════════════════════╝

>>> REGISTRO DE PACIENTES <

═══════════════════════════════════════
         INFORMACIÓN DEL PACIENTE
═══════════════════════════════════════
ID: 1035789456
Nombre: María González Rodríguez
Edad: 45 años
Teléfono: 3201234567
Tipo de Sangre: O+
Plan de Salud: NO
Saldo Pendiente: $0.00
═══════════════════════════════════════

[... operaciones del sistema ...]

╔═══════════════════════════════════════════════════════╗
║          Sistema finalizado exitosamente              ║
╚═══════════════════════════════════════════════════════╝
```

---

## 🔍 Conceptos de POO Aplicados

### 1. Clase y Objeto
- **Clases definidas**: `Paciente`, `Bacteriologo`
- **Objetos creados**: Múltiples instancias de pacientes y bacteriólogos
- Cada objeto tiene su propio estado independiente

### 2. Atributos (Propiedades)
- Representan las características de las entidades del dominio
- Tipos de datos variados: String, int, double, boolean
- Visibilidad `private` para encapsulación

### 3. Métodos (Comportamientos)
- Representan las acciones que pueden realizar los objetos
- Métodos de cálculo: `calcularDescuentoPlanSalud()`, `calcularTarifaPorExamen()`
- Métodos de visualización: `mostrarInformacion()`, `mostrarDatos()`
- Métodos de validación: `esAdultoMayor()`, `esSenior()`
- Métodos de negocio: `agregarExamen()`, `atenderPaciente()`

### 4. Encapsulación
- Atributos privados con acceso controlado
- Getters y setters para manipulación segura
- Validaciones en métodos críticos (pagos, disponibilidad)

### 5. Constructor
- Inicialización de objetos con valores iniciales
- Constructor parametrizado para datos esenciales
- Valores por defecto para atributos opcionales

---

## 🏥 Contexto del Dominio: Diagnóstico Plus

**Descripción del Negocio:**

Diagnóstico Plus es un laboratorio clínico ubicado en la localidad de Chapinero en Bogotá, que se especializa en análisis clínicos, pruebas de laboratorio y exámenes especializados. Con un equipo de 10 bacteriólogos profesionales, el laboratorio atiende aproximadamente 150 pacientes diarios.

**Servicios principales:**
- Exámenes de sangre (hemogramas, perfiles lipídicos, glucosa, etc.)
- Análisis de orina
- Pruebas microbiológicas
- Exámenes especializados (hormonales, marcadores tumorales)

**Clases implementadas:**
1. **Paciente**: Representa a las personas que solicitan los servicios del laboratorio
2. **Bacteriólogo**: Representa a los profesionales que realizan los análisis y atienden pacientes

---

## 📈 Estadísticas del Código

| Métrica | Valor |
|---------|-------|
| Clases creadas | 3 |
| Atributos totales | 13 |
| Métodos totales | 18+ |
| Líneas de código | ~350 |
| Objetos instanciados | 4 |

---

## 🧪 Escenarios de Prueba Implementados

1. **Registro de pacientes** con diferentes edades y tipos de sangre
2. **Activación de plan de salud** y cálculo de descuentos
3. **Agregado de exámenes** y actualización de saldos
4. **Procesamiento de pagos** con validaciones
5. **Verificación de adulto mayor** para prioridad de atención
6. **Registro de bacteriólogos** con especialidades
7. **Atención de pacientes** por bacteriólogos
8. **Verificación de experiencia** (bacteriólogos senior)
9. **Cálculo de tarifas** según años de experiencia
10. **Control de disponibilidad** de bacteriólogos

---

## 🔧 Posibles Mejoras Futuras

Para las siguientes semanas, este código puede evolucionar incorporando:

- **Semana 02**: Más clases como `Examen`, `Muestra`, `Resultado`
- **Semana 03**: Getters/setters completos y validaciones robustas
- **Semana 04**: Herencia con `PacienteVIP`, `BacteriologoSenior`
- **Semana 05**: Polimorfismo con diferentes tipos de exámenes
- **Semana 06**: Interfaces como `Facturable`, `Reportable`
- **Semana 07**: Paquetes organizados y manejo de excepciones
- **Semana 08**: Colecciones para gestionar múltiples entidades
- **Semana 09**: Sistema completo integrado

---

## ✅ Checklist de Entrega

- [x] Código compila sin errores
- [x] Código se ejecuta sin excepciones
- [x] Clase principal con 5+ atributos
- [x] Clase principal con 4+ métodos
- [x] Clase secundaria con 4+ atributos
- [x] Clase secundaria con 3+ métodos
- [x] Programa Main funcional
- [x] Documento ANALISIS.md completo
- [x] Nomenclatura en PascalCase (clases)
- [x] Nomenclatura en camelCase (métodos/variables)
- [x] Comentarios JavaDoc en clases
- [x] Código indentado correctamente
- [x] README.md con instrucciones claras


**Estudiante:** Andres Fernandez
**Ficha:** 3228970-b  
**Programa:** Bootcamp POO Java  
**Instructor:** erik grnados  
**Fecha de Entrega:** Diciembre 2025



