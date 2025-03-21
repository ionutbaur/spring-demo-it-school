package com.example.demo.entity;

import java.time.Instant;

public record Activity(Long id, String title, Instant dueDate, Boolean completed) {
}
