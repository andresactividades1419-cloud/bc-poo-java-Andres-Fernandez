# Mejoras - Semana 03
## Sistema Diagnóstico Plus - Laboratorio Clínico

## 📋 Contexto del Negocio
**Nombre:** Diagnóstico Plus  
**Ubicación:** Bogotá, Localidad de Chapinero  
**Especialidad:** Análisis clínicos, pruebas de laboratorio, exámenes especializados  
**Capacidad:** 150 pacientes diarios, 10 bacteriólogos

## 🔒 Encapsulación Aplicada

### Clase: Bacteriologo (Nueva)
- **Atributos encapsulados:** `idBacteriologo`, `nombre`, `especialidad`, `anosExperiencia`, `telefono`, `email`, `activo`
- **Validaciones agregadas:**
    - ID bacteriólogo: formato `BAC-XXX` (ej: `BAC-001`)
    - Nombre: sin números, no vacío, mínimo 3 caracteres
    - Años experiencia: rango 0-50 años
    - Teléfono: formato internacional válido (`+57123456789`)
    - Email: formato básico válido (`usuario@dominio.ext`)
    - Estado: booleano para activo/inactivo

### Clase: Examen (Refactorizada)
- **Atributos encapsulados:** `codigoExamen`, `nombre`, `tipo`, `costo`, `descripcion`, `tiempoResultado`, `categoria`
- **Validaciones agregadas:**
    - Código examen: formato `XXX-XXX` (ej: `HEM-001`)
    - Costo: no negativo (≥ 0)
    - Tiempo resultado: 1-168 horas (1 hora a 7 días)
    - Nombre, tipo, categoría: no vacíos
    - Descripción: opcional, si es nula se asigna "Sin descripción"
- **Métodos mejorados:**
    - `mostrarInformacion()`: devuelve string formateado con código, nombre y costo
    - `calcularCostoConDescuento(double)`: calcula precio con descuento validado

### Clase: Laboratorio (Refactorizada)
- **Atributos encapsulados:** `nombre`, `direccion`, `telefono`, `capacidadPacientesDiarios`, `numeroBacteriologos`, `horarioAtencion`, `activo`
- **Validaciones agregadas:**
    - Capacidad pacientes: 0-1000 pacientes diarios
    - Número bacteriólogos: 0-100 profesionales
    - Horario atención: no vacío
    - Teléfono: formato con guiones (`601-1234567`)
    - Nombre y dirección: no vacíos
- **Nuevos métodos:**
    - `obtenerInformacionCompleta()`: string formateado con toda la información
    - `calcularCapacidadDisponible(int)`: calcula capacidad restante basada en pacientes atendidos

### Clase: OrdenExamen (Refactorizada)
- **Atributos encapsulados:** `numeroOrden`, `paciente`, `examen`, `fechaOrden`, `medicoSolicitante`, `estado`, `observaciones`
- **Validaciones agregadas:**
    - Número orden: formato `ORD-XXXXXX` (ej: `ORD-000001`)
    - Paciente y examen: no nulos (integridad referencial)
    - Estado: valores predefinidos (`Pendiente`, `Procesando`, `Completado`, `Cancelado`)
    - Fecha: no vacía
    - Médico solicitante: no vacío
    - Observaciones: opcional
- **Métodos mejorados:**
    - `generarResumen()`: información consolidada de la orden
    - `cambiarEstado(String)`: con validación de estado permitido
    - `calcularFechaResultado()`: estimación basada en tiempo del examen

### Clase: Paciente (Refactorizada)
- **Atributos encapsulados:** `identificacion`, `nombre`, `edad`, `genero`, `telefono`, `direccion`, `tipoSangre`, `email`
- **Validaciones agregadas:**
    - Identificación: 5-15 caracteres
    - Nombre: sin números, no vacío, trim aplicado
    - Edad: 0-120 años
    - Tipo sangre: no vacío
    - Teléfono: formato internacional válido
    - Email: formato básico válido
    - Género y dirección: no vacíos
- **Métodos nuevos:**
    - `esMayorDeEdad()`: retorna `true` si edad ≥ 18
    - `obtenerInformacionContacto()`: string con teléfono, email y dirección

## 🏗️ Constructores Sobrecargados

### Clase: Bacteriologo
1. **Constructor completo:** 7 parámetros - toda la información
   ```java
   public Bacteriologo(String id, String nombre, String especialidad, 
                       int experiencia, String telefono, String email, boolean activo)