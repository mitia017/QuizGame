## 2025-05-14 - Shared Scanner for Reliable CLI Input
**Learning:** Multiple Scanner instances on System.in cause NoSuchElementException with piped input due to buffering and stream closing.
**Action:** Use a single shared static Scanner(System.in) instance for all console input.

## 2025-05-14 - Progress Indicators and Prompts in CLI
**Learning:** In console applications, users can easily lose context of where they are in a process (e.g., which question they are on) or when the application is waiting for input.
**Action:** Use "Question X/Y" indicators and consistent input prompts like "> " to improve user orientation and interaction flow.
