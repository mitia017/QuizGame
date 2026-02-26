## 2025-05-14 - Shared Scanner for Reliable CLI Input
**Learning:** Multiple Scanner instances on System.in cause NoSuchElementException with piped input due to buffering and stream closing.
**Action:** Use a single shared static Scanner(System.in) instance for all console input.

## 2025-05-14 - Progress Indicators and Prompts in CLI
**Learning:** In console applications, users can easily lose context of where they are in a process (e.g., which question they are on) or when the application is waiting for input.
**Action:** Use "Question X/Y" indicators and consistent input prompts like "> " to improve user orientation and interaction flow.

## 2025-05-15 - Local Multiplayer Flow and Result Clarity
**Learning:** In local multiplayer CLI games, immediate turn transitions can be jarring. Providing a "Press Enter" prompt allows the next player to be ready. Additionally, consistent "X/Y" score formatting across all player counts reduces cognitive load.
**Action:** Implement "Ready?" prompts for player transitions and ensure all results displays follow a standardized score format.
