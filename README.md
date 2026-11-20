# Minesweeper

A classic Minesweeper desktop game written in Java using Swing.

## Overview

Minesweeper is a logic puzzle game in which the player reveals cells on a square board. Mines are placed randomly, and each revealed number indicates how many mines are in the neighboring eight cells. The player wins by revealing every safe cell and loses by revealing a mine.

## Features

- 22 x 22 board
- Random mine placement
- Approximately 15% of cells contain mines
- Left-click to reveal a cell
- Right-click to place or remove a flag
- Automatic expansion of connected empty cells
- Win and lose dialogs
- Image-based cell states

## Requirements

- Java Development Kit (JDK) 17 or newer
- A graphical desktop environment that supports Swing

## Project Structure

```text
Minesweeper/
├── Main.java
├── Configration/
│   └── GameConfig.java
├── Control/
│   ├── CellsManager.java
│   ├── GameController.java
│   ├── GameDrawManager.java
│   ├── ImageManager.java
│   └── VisualCell.java
├── GameModels/
│   └── Cell.java
└── Resources/
    └── Images/
```

## Run the Game

From the project root directory:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter '*.java' | ForEach-Object { $_.FullName })
java -cp "out;Resources" Main
```

On macOS or Linux, use a colon instead of a semicolon in the classpath:

```bash
javac -d out $(find . -name "*.java")
java -cp "out:Resources" Main
```

## Configuration

The game settings are defined in [Configration/GameConfig.java](Configration/GameConfig.java):

| Setting | Default | Description |
|---|---:|---|
| `WINDOW_TITLE` | Minesweeper | Title shown in the application window |
| `WINDOW_FRAME_WIDTH` | 680 | Window width in pixels |
| `WINDOW_FRAME_HEIGHT` | 650 | Window height in pixels |
| `BOARD_WIDTH` | 22 | Number of rows and columns |
| `MINES_RATIO` | 0.15 | Fraction of board cells containing mines |

---

# كاسحة الألغام

لعبة كاسحة الألغام الكلاسيكية مكتوبة بلغة Java باستخدام مكتبة Swing.

## نظرة عامة

كاسحة الألغام هي لعبة ألغاز منطقية تكشف فيها الخلايا على لوحة مربعة. يتم وضع الألغام عشوائيا، ويشير كل رقم مكشوف إلى عدد الألغام الموجودة في الخلايا المجاورة الثمانية. يفوز اللاعب بكشف جميع الخلايا الآمنة ويخسر عند كشف لغم.

## المميزات

- لوحة بمقاس 22 × 22 خلية
- وضع الألغام عشوائيا
- نحو 15% من الخلايا تحتوي على ألغام
- النقر بزر الفأرة الأيسر لكشف الخلية
- النقر بزر الفأرة الأيمن لوضع علم أو إزالته
- كشف الخلايا الفارغة المتصلة تلقائيا
- نوافذ تنبيه عند الفوز أو الخسارة
- عرض حالات الخلايا بواسطة صور

## المتطلبات

- مجموعة تطوير Java المعروفة باسم JDK الإصدار 17 أو أحدث
- بيئة سطح مكتب تدعم مكتبة Swing

## بنية المشروع

```text
Minesweeper/
├── Main.java
├── Configration/
│   └── GameConfig.java
├── Control/
│   ├── CellsManager.java
│   ├── GameController.java
│   ├── GameDrawManager.java
│   ├── ImageManager.java
│   └── VisualCell.java
├── GameModels/
│   └── Cell.java
└── Resources/
    └── Images/
```

## تشغيل اللعبة

نفذ الأوامر التالية من المجلد الرئيسي للمشروع:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter '*.java' | ForEach-Object { $_.FullName })
java -cp "out;Resources" Main
```

على أنظمة macOS أو Linux، استخدم النقطتين الرأسيتين بدل الفاصلة المنقوطية في مسار الصفوف:

```bash
javac -d out $(find . -name "*.java")
java -cp "out:Resources" Main
```

## الإعدادات

يمكن تعديل إعدادات اللعبة في الملف [Configration/GameConfig.java](Configration/GameConfig.java):

| الإعداد | القيمة الافتراضية | الوصف |
|---|---:|---|
| `WINDOW_TITLE` | Minesweeper | عنوان نافذة التطبيق |
| `WINDOW_FRAME_WIDTH` | 680 | عرض النافذة بالبكسل |
| `WINDOW_FRAME_HEIGHT` | 650 | ارتفاع النافذة بالبكسل |
| `BOARD_WIDTH` | 22 | عدد الصفوف والأعمدة |
| `MINES_RATIO` | 0.15 | نسبة الخلايا التي تحتوي على ألغام |
