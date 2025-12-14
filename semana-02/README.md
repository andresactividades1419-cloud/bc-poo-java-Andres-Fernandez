# 📘 Semana 02 – Clases y Objetos

## 📋 Información General

* **Bootcamp:** Programación Orientada a Objetos en Java
* **Semana:** 02 – Fundamentos de Clases y Objetos
* **Modalidad:** Individual
* **Lenguaje:** Java
* **Dominio:** Laboratorio Clínico
* **Nombre del sistema:** Diagnóstico Plus

---

## 🧪 Contexto del Dominio

**Diagnóstico Plus** es un laboratorio clínico ubicado en la localidad de Chapinero (Bogotá), especializado en análisis clínicos, exámenes de laboratorio y pruebas especializadas. El sistema modela entidades básicas como pacientes, exámenes y órdenes médicas, aplicando los principios de Programación Orientada a Objetos.

---

## 🎯 Objetivo de la Semana

Expandir el sistema creado en la semana 01 mediante:

* La creación de nuevas clases
* La implementación de relaciones entre objetos
* El uso de colecciones (`ArrayList`)
* Un programa principal funcional

---

## 📦 Estructura del Proyecto

```
semana-02/
└── src/
    └── co/edu/sena/semana02/
        ├── Paciente.java
        ├── Examen.java
        ├── OrdenExamen.java
        ├── Laboratorio.java
        └── Main.java
```

---

## 🧩 Clases Implementadas

### 🧑‍⚕️ Paciente

Representa a un paciente del laboratorio.

* **Atributos:** nombre, documento, edad
* **Métodos:** getters, setters y método de negocio `obtenerInformacion()`

### 🧪 Examen

Representa un examen clínico.

* **Atributos:** nombre, tipo, precio
* **Método de negocio:** obtener descripción del examen

### 📄 OrdenExamen

Relaciona un paciente con un examen.

* **Relaciones:**

    * Asociación con `Paciente`
    * Asociación con `Examen`
* **Método de negocio:** cálculo del costo total

### 🏥 Laboratorio

Clase gestora del sistema.

* Usa `ArrayList<OrdenExamen>`
* Permite registrar y mostrar órdenes de examen

---

## ▶️ Clase Principal (Main)

La clase `Main` permite:

* Crear instancias de pacientes y exámenes
* Crear órdenes de examen
* Registrar órdenes en el laboratorio
* Mostrar la información por consola

---

## ✅ Criterios Cumplidos

| Criterio                     | Estado |
| ---------------------------- | ------ |
| 2 nuevas clases              | ✅      |
| Relaciones entre objetos     | ✅      |
| Uso de ArrayList             | ✅      |
| Programa principal funcional | ✅      |
| Código compila sin errores   | ✅      |

✍**Autor:** Andrés Fernández
