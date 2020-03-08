# Thread

Software application needs a "parallel processing" (or "asynchronous behavior"), in order to perform certain task faster as these tasks can be divided into subtasks and these subtasks can be executed in parallel.

Implementations steps:
1. Create a new instance of #Thread class for each processing (e.g., each method) that must be operated concurrently;
2. Create a new runnable instance (that implements the #Runnable interface), for each created Thread instance. In this new runnable instance, you must implement the "run()" method (@override).