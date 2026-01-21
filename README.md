# blinkit-springboot
A Spring Boot GraphQL chatbot application that answers user queries using a Blinkit grocery dataset and a local Large Language Model (LLM).
The system follows a dataset-first approach, using structured data for factual queries and a local LLM (Ollama) as a fallback for explanatory questions.
Built with a clean layered architecture and GraphQL-only interaction

Features

GraphQL Chat Interface

Dataset-First Query Resolution

Local LLM Integration

Intent-Based Routing
Automatically decides whether a query should be answered from the dataset or the LLM.

Lightweight Chatbot UI
Simple HTML + JavaScript frontend that communicates only via GraphQL.


Tech Stack

Backend: Java 21, Spring Boot 3, Spring GraphQL

Database: PostgreSQL

LLM: Ollama (phi3:mini, local inference)

Frontend: HTML, CSS, JavaScript

Build Tool: Gradle
