# Semana 03: Encapsulación y Constructores

## 📋 Información
- **Semana:** 03 - Encapsulación y Constructores
- **Dominio:** Laboratorio Clínico "Diagnóstico Plus"
- **Ubicación:** Bogotá, Localidad de Chapinero
- **Especialidad:** Análisis clínicos, pruebas de laboratorio, exámenes especializados

## 📂 Estructura del Proyecto                                                          

## 🎯 Objetivos Cumplidos
✅ **Ejercicio 1:** Encapsulación Completa (30 puntos)  
✅ **Ejercicio 2:** Sobrecarga de Constructores (25 puntos)  
✅ **Ejercicio 3:** Validaciones (25 puntos)  
✅ **Ejercicio 4:** Documento MEJORAS.md (20 puntos)

## 🏗️ Clases Implementadas

### 1. **Bacteriologo.java** (Nueva)
Representa los 10 bacteriólogos del laboratorio con ID único (BAC-XXX), especialidad, años de experiencia y estado.

### 2. **Examen.java** (Refactorizada)
Gestiona exámenes con código (HEM-001), costo, tiempo de resultado y categoría.

### 3. **Laboratorio.java** (Refactorizada)
Representa el laboratorio con información de contacto, capacidad (150 pacientes/día) y horarios.

### 4. **OrdenExamen.java** (Refactorizada)
Maneja órdenes con número único (ORD-XXXXXX), paciente, examen y estado.

### 5. **Paciente.java** (Refactorizada)
Administra pacientes con datos personales, médicos y de contacto.

### 6. **Main.java** (Principal)
Demuestra el sistema completo con ejemplos y pruebas.

## 🚀 Cómo Ejecutar

### Compilación Manual
```bash
cd semana-03/src
javac co/edu/sena/semana3/*.java
java co.edu.sena.semana3.Main