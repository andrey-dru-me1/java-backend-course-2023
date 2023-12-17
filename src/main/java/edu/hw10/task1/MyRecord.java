package edu.hw10.task1;


record MyRecord(@NotNull String name, @Min(18) @Max(100) int age) {}
