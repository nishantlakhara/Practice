# 🧠 AI Roadmap 2025–2026 — The Definitive Guide

> A **linear, opinionated** roadmap for the current AI landscape.  
> Every step unlocks the next. Don't skip, don't rush, don't tutorial-hell.

---

## 🗺️ The Full Path

```
Python  →  Math  →  Machine Learning  →  Deep Learning  →  Transformers
    →  Generative AI  →  RAG  →  Prompt Engineering  →  Function Calling
    →  Agentic AI  →  MCP  →  A2A  →  Multi-Agent Systems
    →  Fine-Tuning  →  MLOps  →  Deployment
```

---

## ⏱️ Timeline at a Glance

| Step | Topic | Duration |
|------|-------|----------|
| 1 | Python | 3–4 weeks |
| 2 | Math | 3–5 weeks |
| 3 | Machine Learning | 5–7 weeks |
| 4 | Deep Learning | 6–8 weeks |
| 5 | Transformers | 3–4 weeks |
| 6 | Generative AI | 3–4 weeks |
| 7 | RAG | 2–3 weeks |
| 8 | Prompt Engineering | 1–2 weeks |
| 9 | Function Calling | 1–2 weeks |
| 10 | Agentic AI | 3–4 weeks |
| 11 | MCP | 1–2 weeks |
| 12 | A2A Communication | 1–2 weeks |
| 13 | Multi-Agent Systems | 3–4 weeks |
| 14 | Fine-Tuning | 3–4 weeks |
| 15 | MLOps | 3–4 weeks |
| 16 | Deployment | 2–3 weeks |

**Total: ~9–14 months** (10 hrs/week, part-time)

---

## 1️⃣ Python

> Your core tool for everything that follows.

### What to Learn
- Data types, loops, functions, OOP (classes, inheritance)
- File I/O, error handling, decorators, generators
- **NumPy** — vectorized array operations (GPU of the CPU world)
- **Pandas** — DataFrames, groupby, merge, apply
- **Matplotlib / Seaborn** — visualization
- Virtual environments (`venv`, `conda`)
- Jupyter Notebooks & VS Code

### Key Skills
```python
# You should be comfortable with things like this:
import numpy as np

def softmax(x: np.ndarray) -> np.ndarray:
    e_x = np.exp(x - np.max(x))
    return e_x / e_x.sum()
```

### Resources
- [Python for Everybody — Dr. Chuck (Free)](https://www.coursera.org/specializations/python)
- [Kaggle Learn Python (Free, 5 hrs)](https://www.kaggle.com/learn/python)
- [NumPy Quickstart Guide](https://numpy.org/doc/stable/user/quickstart.html)

### ✅ Milestone
Build a **data analysis project** — scrape data, clean it, visualize insights with Pandas + Matplotlib.

---

## 2️⃣ Math

> You don't need a PhD. You need enough to understand *why* things work.

### Linear Algebra (Most Important)
- Vectors, matrices, matrix multiplication
- Dot product, transpose, inverse
- Eigenvalues & eigenvectors
- Why it matters: neural networks are *just* matrix multiplications

### Calculus
- Derivatives, partial derivatives
- Chain rule → **this is backpropagation**
- Gradient descent: $w = w - \alpha \cdot \frac{\partial L}{\partial w}$

### Probability & Statistics
- Probability distributions (Gaussian, Bernoulli)
- Bayes' theorem
- Maximum Likelihood Estimation (MLE)
- Cross-entropy loss (you'll use this daily)

### Resources
- [3Blue1Brown — Essence of Linear Algebra](https://www.youtube.com/playlist?list=PLZHQObOWTQDPD3MizzM2xVFitgF8hE_ab) ⭐
- [3Blue1Brown — Essence of Calculus](https://www.youtube.com/playlist?list=PLZHQObOWTQDMsr9K-rj53DwVRMYO3t5Yr) ⭐
- [StatQuest — Statistics](https://www.youtube.com/@statquest) ⭐

### ✅ Milestone
Implement **gradient descent from scratch** in Python to minimize a simple loss function.

---

## 3️⃣ Machine Learning

> Classical ML is still everywhere in industry. Don't dismiss it.

### Core Concepts
- Supervised vs. Unsupervised vs. Self-Supervised Learning
- The ML pipeline: Data → Features → Model → Evaluate → Iterate
- **Bias-Variance tradeoff** — the fundamental tension in ML
- Overfitting, underfitting, regularization (L1/L2)
- Train / Validation / Test splits, Cross-validation

### Must-Know Algorithms

| Type | Algorithms |
|------|-----------|
| Regression | Linear Regression, Ridge, Lasso |
| Classification | Logistic Regression, SVM, KNN |
| Ensemble | **Random Forest, XGBoost, LightGBM** ← still used in prod |
| Clustering | K-Means, DBSCAN |
| Dim. Reduction | PCA, t-SNE, UMAP |

### Evaluation Metrics
- Classification: Accuracy, Precision, Recall, F1, AUC-ROC
- Regression: MAE, RMSE, R²
- Always check the confusion matrix

### Tool: Scikit-learn
```python
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import cross_val_score

model = RandomForestClassifier(n_estimators=100)
scores = cross_val_score(model, X, y, cv=5)
```

### Resources
- [Hands-On Machine Learning — Aurélien Géron](https://www.oreilly.com/library/view/hands-on-machine-learning/9781492032632/)
- [Google ML Crash Course (Free)](https://developers.google.com/machine-learning/crash-course)
- [Kaggle Learn ML](https://www.kaggle.com/learn)

### ✅ Milestone
Complete a **Kaggle competition** (tabular data). Rank in the top 50%.

---

## 4️⃣ Deep Learning

> When classical ML hits its ceiling, deep learning takes over.

### Neural Network Fundamentals
- Perceptrons → MLPs (Multi-Layer Perceptrons)
- Activation functions: ReLU, Sigmoid, Softmax, GELU
- Loss functions: Cross-entropy, MSE
- **Backpropagation** — understand the chain rule in code, not just theory
- Optimizers: SGD → Adam → AdamW
- Batch Normalization, Dropout, Weight Decay

### Key Architectures

#### CNNs (Convolutional Neural Networks)
- Convolution, pooling, stride, padding
- Use case: images
- Classics: LeNet → AlexNet → ResNet → EfficientNet

#### RNNs / LSTMs / GRUs
- Sequence modeling, handling variable-length inputs
- Solved vanishing gradients (before Transformers took over)
- Still used in some time-series problems

### Framework: PyTorch ← Learn This, Not TensorFlow

```python
class SimpleNN(nn.Module):
    def __init__(self):
        super().__init__()
        self.layers = nn.Sequential(
            nn.Linear(784, 256),
            nn.ReLU(),
            nn.Linear(256, 10)
        )

    def forward(self, x):
        return self.layers(x)
```

### Resources
- [Andrej Karpathy — Neural Networks: Zero to Hero](https://www.youtube.com/playlist?list=PLAqhIrjkxbuWI23v9cThsA9GvCAUhRvKZ) ⭐ (best on the internet)
- [fast.ai Practical Deep Learning](https://course.fast.ai/) ⭐
- [Deep Learning Specialization — Andrew Ng (Coursera)](https://www.coursera.org/specializations/deep-learning)

### ✅ Milestone
Build and train a **CNN from scratch** on CIFAR-10 that achieves >85% accuracy.

---

## 5️⃣ Transformers

> The architecture that powers GPT, BERT, Gemini, Claude — everything modern AI.

### The Attention Mechanism
> *"Attention is All You Need"* (Vaswani et al., 2017) — the paper that changed everything.

$$\text{Attention}(Q, K, V) = \text{softmax}\left(\frac{QK^T}{\sqrt{d_k}}\right)V$$

- **Self-attention**: every token attends to every other token
- **Multi-head attention**: multiple attention heads capture different patterns
- **Positional encoding**: inject position information (no recurrence needed)

### Architecture Variants

| Type | Examples | Use Case |
|------|---------|---------|
| Encoder-only | BERT, RoBERTa | Classification, embeddings |
| Decoder-only | GPT-2/3/4, LLaMA, Gemini | Text generation |
| Encoder-Decoder | T5, BART | Translation, summarization |

### Vision Transformers (ViT)
- Patch-based image processing using attention
- Foundation for CLIP, SAM, DINO

### Resources
- [Andrej Karpathy — Let's Build GPT from Scratch](https://www.youtube.com/watch?v=kCc8FmEb1nY) ⭐⭐
- [The Illustrated Transformer — Jay Alammar](https://jalammar.github.io/illustrated-transformer/) ⭐
- [HuggingFace NLP Course (Free)](https://huggingface.co/learn/nlp-course)

### ✅ Milestone
**Implement a mini GPT from scratch** (character-level, ~100 lines of PyTorch). Then use HuggingFace to fine-tune BERT for text classification.

---

## 6️⃣ Generative AI

> LLMs, image generation, audio — the frontier of AI applications.

### Large Language Models (LLMs)

#### How They're Built
1. **Pre-training** — predict next token on billions of tokens of text
2. **Supervised Fine-tuning (SFT)** — instruction following
3. **RLHF / DPO** — align with human preferences

#### Key Models to Know (2025–2026)

| Company | Models |
|---------|-------|
| OpenAI | GPT-4o, o3, o4-mini |
| Google | Gemini 2.5 Pro/Flash, Gemma 3 |
| Anthropic | Claude 3.5/4 Sonnet, Haiku |
| Meta | LLaMA 3.x, LLaMA 4 |
| Open Source | DeepSeek R1, Qwen 3, Phi-4, Mistral |

#### Scaling Laws
- More data + more compute + more parameters = better models
- **Emergent abilities**: capabilities that appear only beyond a certain scale

### Multimodal Generation
- **Images**: Stable Diffusion 3, FLUX, DALL-E 3, Midjourney
- **Video**: Sora, Runway Gen-3, Kling, Veo 2
- **Audio**: Whisper (STT), ElevenLabs (TTS), Bark
- **Code**: GitHub Copilot, Cursor, Claude Code

### APIs to Use
- OpenAI API, Anthropic API, Google Gemini API
- Run locally: **Ollama** (free, runs LLaMA/Qwen/Gemma locally)

### Resources
- [Full Stack LLM Bootcamp (Free)](https://fullstackdeeplearning.com/)
- [Andrej Karpathy — Intro to LLMs](https://www.youtube.com/watch?v=zjkBMFhNj_g)
- [Simon Willison's Blog](https://simonwillison.net/) — best practitioner writing

### ✅ Milestone
Build a **CLI chatbot** using the OpenAI or Gemini API with conversation memory (message history).

---

## 7️⃣ RAG — Retrieval-Augmented Generation

> Giving LLMs access to *your* data without expensive fine-tuning.

### Why RAG?
LLMs have a **knowledge cutoff** and can't know your private documents.  
RAG = retrieve relevant context → inject into prompt → LLM answers grounded in facts.

### The RAG Pipeline

```
User Query
    ↓
[Query Embedding]  ←── Embedding Model (e.g., text-embedding-3-small)
    ↓
[Vector Search]    ←── Vector DB (Chroma, Pinecone, Weaviate, Qdrant)
    ↓
[Top-K Chunks Retrieved]
    ↓
[Augmented Prompt] = System + Context + User Query
    ↓
[LLM Response]
```

### Key Concepts
- **Chunking strategies**: fixed-size, sentence, semantic, recursive
- **Embedding models**: OpenAI `text-embedding-3`, Cohere, `bge-m3`, `nomic-embed`
- **Vector databases**: ChromaDB (local), Pinecone (managed), Qdrant (self-host)
- **Reranking**: Cross-encoder reranking for better precision
- **Hybrid search**: BM25 (keyword) + vector search combined

### Advanced RAG Patterns
- **HyDE** — Hypothetical Document Embeddings
- **Multi-query retrieval** — generate multiple query variations
- **RAPTOR** — hierarchical document summarization for retrieval
- **Agentic RAG** — agent decides when and what to retrieve

### Tools
- **LangChain / LlamaIndex** — RAG orchestration
- **ChromaDB** — start here (local, easy)
- **Pinecone / Weaviate** — production-scale

### Evaluation
- **RAGAS** — faithfulness, answer relevancy, context precision
- Check for hallucinations — LLM answering outside retrieved context

### Resources
- [LangChain RAG Tutorial](https://python.langchain.com/docs/tutorials/rag/)
- [LlamaIndex Docs](https://docs.llamaindex.ai/)
- [RAGAS Paper & Library](https://docs.ragas.io/)

### ✅ Milestone
Build a **RAG chatbot** that answers questions over a set of PDFs you upload. Evaluate it with RAGAS.

---

## 8️⃣ Prompt Engineering

> The interface between you and LLM intelligence. Underrated skill.

### Core Techniques

| Technique | What It Is | When to Use |
|-----------|-----------|-------------|
| Zero-shot | Direct question, no examples | Simple tasks |
| Few-shot | 2–5 examples in the prompt | Structured output, specific format |
| Chain-of-Thought (CoT) | "Think step by step" | Reasoning, math, logic |
| System Prompt Design | Persona, constraints, format rules | All production use cases |
| Self-Consistency | Sample multiple CoT paths, vote | Complex reasoning |
| ReAct | Reason → Act → Observe loop | Agents (see next step) |

### Structured Output
```python
# Always prefer structured output for reliability
from openai import OpenAI
import json

response = client.chat.completions.create(
    model="gpt-4o",
    response_format={"type": "json_object"},
    messages=[{"role": "user", "content": "Extract name and age from: 'John is 25 years old'"}]
)
```

### Prompt Pitfalls
- Vague instructions → vague output. Be explicit.
- Long ambiguous prompts → use XML tags to structure sections
- No output format specified → model will improvise (bad for pipelines)

### Prompt Injection & Security
- Users can try to override your system prompt
- Always sanitize user inputs in production

### Resources
- [OpenAI Prompt Engineering Guide](https://platform.openai.com/docs/guides/prompt-engineering)
- [Anthropic Prompt Library](https://docs.anthropic.com/en/prompt-library/library)
- [Lilian Weng — Prompt Engineering](https://lilianweng.github.io/posts/2023-03-15-prompt-engineering/)

### ✅ Milestone
Build a **prompt template library** for 5 real business tasks (extraction, summarization, classification, generation, Q&A) and compare performance across GPT-4o, Claude, and Gemini.

---

## 9️⃣ Function Calling (Tool Use)

> The bridge between LLMs and the real world.

### What Is It?
LLMs can't *do* things — they can only generate text.  
**Function calling** lets you define tools the LLM can "call", and you execute them.

```python
tools = [{
    "type": "function",
    "function": {
        "name": "get_weather",
        "description": "Get current weather for a city",
        "parameters": {
            "type": "object",
            "properties": {
                "city": {"type": "string"},
                "unit": {"type": "string", "enum": ["celsius", "fahrenheit"]}
            },
            "required": ["city"]
        }
    }
}]

# LLM decides when to call this — you execute the actual function
```

### The Function Calling Loop
```
User: "What's the weather in Mumbai?"
    ↓
LLM: [decides to call get_weather(city="Mumbai")]
    ↓
You: execute get_weather("Mumbai") → {"temp": 32, "condition": "Humid"}
    ↓
LLM: "It's currently 32°C and humid in Mumbai."
```

### Real-World Tools to Build
- Search (web, docs, database)
- Code execution (Python sandbox)
- File read/write
- API calls (Slack, email, calendar)
- Browser automation

### Parallel Tool Calls
Modern LLMs (GPT-4o, Claude 3.5+, Gemini) can call multiple tools in one turn — critical for efficiency in agents.

### ✅ Milestone
Build a **personal assistant** that can: (1) search the web, (2) check your calendar, (3) send a Slack message — all via function calling.

---

## 🔟 Agentic AI

> LLMs that can plan, reason, use tools, and complete multi-step tasks autonomously.

### What Makes an Agent?

```
Agent = LLM + Memory + Tools + Planning + (optional) other Agents
```

### The Core Loop
```
Perceive (input/observation)
    ↓
Think (LLM reasons about what to do)
    ↓
Act (call a tool / generate output)
    ↓
Observe (get result)
    ↓
Repeat until goal achieved
```

### Key Agent Patterns

| Pattern | Description |
|---------|-------------|
| **ReAct** | Reason + Act interleaved — most common |
| **Plan-and-Execute** | First make a full plan, then execute steps |
| **Reflexion** | Self-critique and retry on failure |
| **Self-Ask** | Decompose complex questions into sub-questions |

### Memory in Agents

| Memory Type | What It Stores | Implementation |
|-------------|---------------|---------------|
| In-context (short-term) | Current conversation | Message history |
| Episodic | Past interactions | Vector DB retrieval |
| Semantic | Facts & knowledge | Vector DB |
| Procedural | How to do things | System prompt / tools |

### Agent Frameworks

| Framework | Best For |
|-----------|---------|
| **LangGraph** | Stateful, complex, production agents (recommended) |
| **CrewAI** | Role-based multi-agent teams, fast to prototype |
| **AutoGen** | Research, conversational agents |
| **Google ADK (Antigravity)** | Google ecosystem, production-grade |
| **Pydantic AI** | Type-safe, structured agent outputs |

### Resources
- [LangGraph Docs & Tutorials](https://langchain-ai.github.io/langgraph/)
- [Harrison Chase — Building Agents (YouTube)](https://www.youtube.com/@LangChain)
- [Andrew Ng — AI Agents in LangGraph (Coursera)](https://www.coursera.org/learn/ai-agents-in-langgraph)

### ✅ Milestone
Build a **coding agent** that: reads a task description, writes code, runs it in a sandbox, debugs errors, and returns a working solution.

---

## 1️⃣1️⃣ MCP — Model Context Protocol

> The USB standard for connecting LLMs to tools, data, and services.

### What Is MCP?
Introduced by **Anthropic (2024)**, MCP is an open protocol that standardizes how LLMs connect to:
- **Tools** (functions to call)
- **Resources** (data sources: files, databases, APIs)
- **Prompts** (reusable prompt templates)

Think of MCP as **USB-C for AI** — one standard interface for everything.

### Why MCP Matters
- **Before MCP**: Every app had to write custom integrations for every tool
- **After MCP**: Write the MCP server once → any MCP-compatible LLM client can use it

```
Claude / GPT / Gemini  ←→  MCP Client  ←→  MCP Server  ←→  Your Data/Tools
                           (standard)      (you build)
```

### MCP Architecture

```
MCP Host (e.g., Claude Desktop, Cursor, your app)
    ↓
MCP Client (1 per server connection)
    ↓
MCP Server (exposes tools/resources/prompts)
    ↓
Your actual service (filesystem, DB, API, etc.)
```

### Transport Layers
- **stdio** — for local servers (run as subprocess)
- **HTTP + SSE** — for remote/networked servers

### Build an MCP Server (Python)
```python
from mcp.server.fastmcp import FastMCP

mcp = FastMCP("MyServer")

@mcp.tool()
def search_database(query: str) -> str:
    """Search the company knowledge base"""
    results = db.search(query)
    return str(results)

@mcp.resource("db://schema")
def get_schema() -> str:
    """Get the database schema"""
    return db.get_schema()

if __name__ == "__main__":
    mcp.run()
```

### Ecosystem
- **Claude Desktop** — built-in MCP host
- **Cursor / Windsurf** — IDE with MCP support
- [mcp.so](https://mcp.so) — MCP server directory (hundreds of servers)
- Popular servers: filesystem, GitHub, Slack, Postgres, browser

### Resources
- [Official MCP Docs](https://modelcontextprotocol.io/introduction)
- [MCP Python SDK (GitHub)](https://github.com/modelcontextprotocol/python-sdk)
- [Building MCP Servers — Anthropic](https://modelcontextprotocol.io/quickstart/server)

### ✅ Milestone
Build an **MCP server** that exposes your local notes/files as a resource + a search tool. Connect it to Claude Desktop and chat with your own data.

---

## 1️⃣2️⃣ A2A — Agent-to-Agent Communication

> Agents that can discover, communicate with, and delegate to other agents.

### What Is A2A?
**Google's Agent-to-Agent (A2A) Protocol (2025)** is an open standard for agents to:
- **Discover** other agents (via Agent Cards)
- **Communicate** using structured task messages
- **Delegate** sub-tasks to specialized agents
- **Collaborate** across different frameworks and organizations

Works alongside MCP: **MCP connects agents to tools/data**, **A2A connects agents to other agents**.

### Core Concepts

#### Agent Card
A JSON metadata file that describes an agent's capabilities:
```json
{
  "name": "Data Analysis Agent",
  "description": "Specializes in statistical analysis and visualization",
  "url": "https://agent.example.com",
  "capabilities": {
    "streaming": true,
    "pushNotifications": false
  },
  "skills": [
    {
      "id": "data-viz",
      "name": "Data Visualization",
      "description": "Creates charts and graphs from data"
    }
  ]
}
```

#### Task Lifecycle
```
SUBMITTED → WORKING → (COMPLETED | FAILED | CANCELED)
                     ↓
               INPUT_REQUIRED (agent needs more info → human-in-loop)
```

#### Communication Model
- Agent A sends a **Task** to Agent B's endpoint
- Agent B processes and returns **Artifacts** (results)
- Supports streaming for long-running tasks
- Works over HTTP/JSON — framework-agnostic

### MCP vs A2A — When to Use What

| | MCP | A2A |
|--|-----|-----|
| Connects | Agent ↔ Tools/Data | Agent ↔ Agent |
| Analogy | USB (peripherals) | Internet (machines) |
| Use for | Databases, APIs, files | Delegation, collaboration |
| Initiated by | LLM deciding to use a tool | Orchestrator agent |

### Frameworks Supporting A2A
- **Google ADK** — native A2A support
- **LangGraph** — A2A integration
- **CrewAI** — multi-agent with A2A compatibility

### Resources
- [Google A2A Protocol (GitHub)](https://github.com/google/A2A)
- [A2A Specification Docs](https://google.github.io/A2A/)
- [Google ADK + A2A Tutorial](https://google.github.io/adk-docs/)

### ✅ Milestone
Build **two agents** — a Research Agent and a Writing Agent — that communicate via A2A. The Research Agent gathers information; the Writing Agent turns it into a report.

---

## 1️⃣3️⃣ Multi-Agent Systems

> Orchestrating teams of specialized AI agents to solve complex problems.

### Why Multi-Agent?
- Tasks too long for a single context window
- Specialization (researcher, coder, critic, planner)
- Parallelization (multiple agents work simultaneously)
- Verification (agents check each other's work)

### Architectures

#### Hierarchical
```
Orchestrator Agent
    ├── Research Agent
    ├── Coding Agent
    └── Review Agent
```

#### Collaborative / Peer-to-Peer
```
Agent A ←→ Agent B ←→ Agent C
```

#### Pipeline
```
Input → Agent 1 → Agent 2 → Agent 3 → Output
```

### Key Challenges
- **State management** — what does each agent know?
- **Coordination** — who does what, in what order?
- **Error handling** — what if an agent fails mid-task?
- **Loops** — agents can get stuck in infinite loops
- **Trust** — agent-generated content can be wrong/malicious
- **Cost** — multi-agent = many LLM calls = $$$

### Human-in-the-Loop (HITL)
Critical for production. Know when to pause and ask a human:
- Before irreversible actions (send email, delete files)
- When confidence is low
- At key decision points

### Frameworks

| Framework | Strengths |
|-----------|----------|
| **LangGraph** | Best for production; explicit state graphs |
| **CrewAI** | Fast prototyping; role-based teams |
| **AutoGen** | Research; conversational multi-agent |
| **Google ADK** | Production; native A2A + Vertex AI |
| **Magentic-One** | Microsoft; generalist multi-agent |

### Evaluation
- Task completion rate
- Number of steps (efficiency)
- Hallucination rate per agent
- Cost per task

### Resources
- [LangGraph Multi-Agent Docs](https://langchain-ai.github.io/langgraph/how-tos/multi-agent-network/)
- [CrewAI Docs](https://docs.crewai.com/)
- [Andrew Ng — AI Agents (deeplearning.ai)](https://www.deeplearning.ai/courses/ai-agents-in-langgraph/)

### ✅ Milestone
Build a **multi-agent research assistant**: Orchestrator → Researcher (web search) → Analyst (data extraction) → Writer (report generation). Use LangGraph with human-in-loop approval before final output.

---

## 1️⃣4️⃣ Fine-Tuning

> Teaching a pre-trained model new behaviors on your data.

### When to Fine-Tune?
**Prompt engineering first. RAG second. Fine-tune last.**

Fine-tune when:
- You need a specific style, tone, or persona (consistent)
- Model needs to know domain-specific formats/structures
- You want a cheaper/faster small model to match a large one
- Classification / extraction tasks at scale

Don't fine-tune for: knowledge updates → use RAG instead.

### Techniques

| Method | What It Does | Cost |
|--------|-------------|------|
| **Full Fine-tuning** | Update all model weights | Very High |
| **LoRA** | Train low-rank adapter layers only | Low |
| **QLoRA** | LoRA + 4-bit quantization | Very Low ← start here |
| **SFT** | Supervised Fine-Tuning on instruction pairs | Medium |
| **DPO** | Direct Preference Optimization (no reward model) | Medium |
| **RLHF** | Reinforcement Learning from Human Feedback | High |

### Data Format (SFT)
```json
[
  {
    "messages": [
      {"role": "system", "content": "You are a medical coding assistant."},
      {"role": "user", "content": "Code this diagnosis: chest pain with elevated troponin"},
      {"role": "assistant", "content": "ICD-10: I21.9 — Acute MI, unspecified"}
    ]
  }
]
```

### Fine-Tuning Stack

```
Dataset Prep → Training → Evaluation → Merge & Quantize → Deploy
```

- **Unsloth** ← fastest QLoRA, 2x faster than standard (start here)
- **HuggingFace PEFT** — LoRA/QLoRA implementation
- **Axolotl** — config-driven training pipeline
- **TRL** — training RL-based alignment (DPO, PPO)
- **W&B** — experiment tracking during training

### Model Selection for Fine-Tuning
| Model | Size | Best For |
|-------|------|---------|
| Gemma 3 2B/4B | Small | Mobile, edge, fast iteration |
| Phi-4 Mini | Small | Reasoning tasks |
| LLaMA 3.2 3B/8B | Medium | General purpose |
| Qwen 2.5 7B/14B | Medium | Multilingual, code |
| Mistral 7B | Medium | Instruction following |

### Evaluation After Fine-Tuning
- Compare against base model on your task
- Check for **catastrophic forgetting** (did it lose general ability?)
- Run on held-out test set
- Human evaluation for quality

### Resources
- [Unsloth Fine-tuning Guide](https://docs.unsloth.ai/)
- [HuggingFace PEFT Docs](https://huggingface.co/docs/peft)
- [Sebastian Raschka — Fine-tuning LLMs](https://magazine.sebastianraschka.com/)

### ✅ Milestone
**QLoRA fine-tune LLaMA 3.2 3B** on a custom instruction dataset (e.g., customer support Q&A). Run inference and compare to the base model.

---

## 1️⃣5️⃣ MLOps

> Making AI systems reliable, observable, and maintainable in production.

### The ML Lifecycle in Production

```
Data → Experiment → Train → Evaluate → Register → Deploy → Monitor → Retrain
         ↑_________________________________________|
                      (feedback loop)
```

### Experiment Tracking
- **Weights & Biases (W&B)** ⭐ — log metrics, hyperparams, artifacts, visualize
- **MLflow** — open-source alternative, model registry
- **Neptune.ai** — team-focused experiment tracking

### Data Versioning
- **DVC (Data Version Control)** — Git for datasets and model artifacts
- Track data changes alongside code changes

### LLMOps (LLM-Specific)
This is the new frontier. LLMs have unique operational challenges.

| Challenge | Solution |
|-----------|---------|
| Prompt versioning | LangSmith, PromptLayer |
| LLM evaluation | RAGAS, PromptFoo, LangSmith |
| Observability / tracing | **Langfuse** ⭐, Helicone, Arize |
| Guardrails | NeMo Guardrails, Guardrails AI |
| Cost tracking | Helicone, LangFuse |
| A/B testing prompts | LangSmith, custom |

### CI/CD for ML
```yaml
# Example GitHub Actions pipeline
- Run data validation tests
- Run unit tests on model code
- Train model on PR (small data)
- Evaluate against baseline
- Auto-deploy if metrics pass threshold
```

### Tools: Great Expectations, DVC, GitHub Actions, Docker

### Monitoring
- **Data drift**: input distribution shifting over time
- **Concept drift**: relationship between input/output changing
- **Model degradation**: performance dropping
- **Tools**: Evidently AI, WhyLabs, Arize

### Resources
- [Designing ML Systems — Chip Huyen](https://www.oreilly.com/library/view/designing-machine-learning/9781098107956/) ⭐
- [Made With ML — MLOps Course (Free)](https://madewithml.com/)
- [Full Stack Deep Learning](https://fullstackdeeplearning.com/)

### ✅ Milestone
Set up a **complete MLOps pipeline**: DVC for data versioning → W&B for experiment tracking → GitHub Actions for CI → Langfuse for LLM observability.

---

## 1️⃣6️⃣ Deployment

> Getting your AI from your laptop to production.

### Serving an LLM Application

#### Architecture Options

| Approach | When to Use |
|----------|------------|
| Managed API (OpenAI/Anthropic) | Fast to start, pay per token |
| Self-hosted inference | Cost control at scale, data privacy |
| Hybrid | Use API for rare complex tasks, local for common |

#### Self-Hosted Inference Stack
- **vLLM** ⭐ — fastest production LLM inference, PagedAttention
- **Ollama** — local development and testing
- **TGI (Text Generation Inference)** — HuggingFace's production server
- **llama.cpp** — CPU inference, edge deployment

### Building the API Layer

```python
# FastAPI — the standard for ML model serving
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class ChatRequest(BaseModel):
    message: str
    session_id: str

@app.post("/chat")
async def chat(request: ChatRequest):
    response = await agent.arun(request.message, session_id=request.session_id)
    return {"response": response}
```

### Containerization & Orchestration
```dockerfile
FROM python:3.11-slim
WORKDIR /app
COPY requirements.txt .
RUN pip install -r requirements.txt
COPY . .
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
```

- **Docker** — package your app
- **Docker Compose** — local multi-service setup
- **Kubernetes** — production orchestration at scale

### Cloud Deployment Options

| Platform | Best For |
|----------|---------|
| **Cloud Run (GCP)** | Serverless, auto-scaling, pay per request |
| **AWS Lambda** | Event-driven, small models |
| **AWS SageMaker** | Full ML platform, model registry |
| **Vertex AI (GCP)** | Google's full ML platform |
| **Modal** | GPU functions as a service (easy, modern) |
| **Render / Railway** | Simple deployments, small teams |
| **RunPod** | Cheap GPU inference |

### Streaming Responses
Users expect streaming for chatbots:
```python
async def stream_chat(message: str):
    async for chunk in llm.astream(message):
        yield f"data: {chunk.content}\n\n"
```

### Production Checklist
- [ ] Rate limiting
- [ ] Authentication (API keys / OAuth)
- [ ] Input validation & sanitization
- [ ] Output guardrails
- [ ] Error handling & retries
- [ ] Logging & distributed tracing
- [ ] Cost monitoring (set spend alerts!)
- [ ] Autoscaling configured
- [ ] Health checks & readiness probes

### Resources
- [FastAPI Docs](https://fastapi.tiangolo.com/)
- [vLLM Docs](https://docs.vllm.ai/)
- [Modal — Deploy LLMs](https://modal.com/docs)

### ✅ Final Milestone
**Deploy a full agentic RAG application** to cloud:
- FastAPI backend with streaming
- LangGraph agent with tools
- ChromaDB / Pinecone for retrieval
- Langfuse for observability
- Docker + Cloud Run
- GitHub Actions CI/CD

---

## 🛠️ Your Core Toolkit

```
Language:        Python 3.11+
ML:              Scikit-learn, XGBoost
Deep Learning:   PyTorch + Lightning
LLM Framework:   LangChain / LangGraph, LlamaIndex
HuggingFace:     Transformers, PEFT, TRL, Datasets
Local LLM:       Ollama, vLLM
Vector DB:       ChromaDB (dev) → Pinecone/Qdrant (prod)
Fine-tuning:     Unsloth, Axolotl
Agents:          LangGraph, CrewAI, Google ADK
MCP:             MCP Python SDK
Experiment:      Weights & Biases
LLM Observ:      Langfuse
API:             FastAPI + Uvicorn
Container:       Docker + Docker Compose
Cloud:           GCP Cloud Run / Modal (GPU)
CI/CD:           GitHub Actions + DVC
```

---

## 🏗️ Portfolio Projects (Do These)

| Level | Project | Skills |
|-------|---------|--------|
| 🟢 | Kaggle tabular + EDA notebook | Python, ML, Pandas |
| 🟢 | CNN image classifier (PyTorch) | Deep Learning |
| 🟡 | RAG chatbot over your PDFs | RAG, Vector DB, LLMs |
| 🟡 | Fine-tune Gemma on custom data | QLoRA, PEFT |
| 🟡 | Multi-tool AI agent | Function Calling, Agents |
| 🔴 | MCP server for your company's data | MCP, Python |
| 🔴 | Multi-agent research pipeline | A2A, LangGraph, MAS |
| 🔴 | End-to-end deployed AI product | MLOps, FastAPI, Cloud |

---

## 📚 Top Resources (Curated)

| Resource | Why |
|----------|-----|
| [Andrej Karpathy YouTube](https://www.youtube.com/@AndrejKarpathy) | Best technical LLM content |
| [fast.ai](https://course.fast.ai/) | Best practical DL course |
| [HuggingFace Learn](https://huggingface.co/learn) | Best for Transformers + LLMs |
| [LangChain Docs + Academy](https://academy.langchain.com/) | Agents + RAG |
| [Chip Huyen — Designing ML Systems](https://www.oreilly.com/library/view/designing-machine-learning/9781098107956/) | Best MLOps book |
| [MCP Docs](https://modelcontextprotocol.io/) | MCP official |
| [A2A Protocol](https://google.github.io/A2A/) | A2A official |
| [Simon Willison's Weblog](https://simonwillison.net/) | Best practitioner writing |
| [Lilian Weng's Blog](https://lilianweng.github.io/) | Best technical AI blog |

---

> [!TIP]
> **Build the whole stack at least once end-to-end** — even a simple one. Python script → fine-tuned model → deployed agent with MCP tools → monitored in production. That experience is worth more than any course.

> [!IMPORTANT]
> **The field moves fast.** MCP was released in late 2024. A2A in early 2025. By the time you're reading this, new protocols may exist. Learn the fundamentals deeply — they don't change. The tools on top change constantly.

---

*Last updated: August 2026 | Focused on what's actually used in production AI teams today.*
