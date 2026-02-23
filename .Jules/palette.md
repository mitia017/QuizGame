## 2025-05-15 - Interactive CLI Enhancements
**Learning:** In CLI applications, users need clear visual cues for input states and progress tracking. Multiple Scanner instances in Java can cause stability issues with piped input.
**Action:** Use a single shared Scanner(System.in) to ensure stability, and implement consistent prompts (e.g., '> ') and progress indicators (e.g., 'Question X/Y') to improve user orientation and flow.
