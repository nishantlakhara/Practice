🚀 **Design Pattern Series | Behavioral Design Patterns | #6 Memento Pattern**

Have you ever used:

↩️ **Undo** in an editor?
🎮 **Save Game** and load an earlier state?
📄 **Version History** in a document?

How does an application remember an object's **previous state** and restore it later?

That's where the **Memento Pattern** comes in.

The Memento Pattern allows an object to **capture and externalize its internal state without breaking encapsulation**, so that it can be restored later.

### Think of it like this

📝 **Originator** → The object whose state changes

📸 **Memento** → Snapshot of its state

🗃️ **Caretaker** → Stores the snapshots

```text
Originator
    │
    │ createMemento()
    ▼
 Memento ──────► Caretaker
    ▲                │
    │                │ get()
    └──── restore ───┘
```

The important idea:

**The Caretaker stores the snapshot but doesn't need to know the object's internal details.**

### Benefits

✅ Supports Undo / Redo

✅ Preserves encapsulation

✅ Keeps state management separate from the main object

✅ Makes state rollback easier

### Where is it used?

🔹 Text editors & IDEs
🔹 Game save points
🔹 Photo editing
🔹 Document version history
🔹 Configuration rollback

### Java / Framework examples

☕ IDE/editor undo stacks
☕ Transaction rollback concepts
☕ Snapshot-based state management
☕ Serialization-based state snapshots

> **"Capture and externalize an object's internal state so that the object can be restored to this state later."** — Gang of Four (GoF)

📌 **This post includes:**

• A visual explanation of the **problem and solution**

• A separate **Java structure & code walkthrough**

---

Follow for more Java, System Design, Low-Level Design, and Design Pattern content.

🔗 **Nishant Lakhara**
[https://www.linkedin.com/in/nishant-lakhara-97037a16/](https://www.linkedin.com/in/nishant-lakhara-97037a16/)

#Java #DesignPatterns #BehavioralPatterns #MementoPattern #SystemDesign #LowLevelDesign #SoftwareArchitecture #CleanCode #JavaDeveloper #Programming #Coding #Tech
