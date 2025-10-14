        # Калькулятор с SOLID архитектурой

Проект консольного калькулятора с применением принципов SOLID.

## Поддерживаемые операции
- + сложение
- - вычитание
- * умножение
- / деление
- // целочисленное деление
- ^ возведение в степень
- % остаток от деления

## Архитектура
Применены принципы SOLID:
- Single Responsibility
- Open/Closed
- Liskov Substitution
- Interface Segregation
- Dependency Inversion

## Запуск
\`\`\`bash
javac -d out src/CalcVar111092025/*.java
java -cp out CalcVar111092025.Main
\`\`\`
"@ | Out-File -FilePath "README.md" -Encoding UTF8