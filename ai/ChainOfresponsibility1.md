🚀 Design Pattern Series | Behavioral Design Patterns | #1 Chain of Responsibility Pattern



Have you ever written long if-else or switch-case statements just to decide who should handle a request?

Imagine an expense approval system.

A ₹2,000 expense can be approved by a Team Lead.

A ₹25,000 expense needs a Manager.

A ₹2,00,000 expense goes to the Director.

A ₹20,00,000 expense requires the CFO.

As the business grows, adding new approval levels means modifying existing code, making it harder to maintain, test, and extend.

This is exactly the problem the Chain of Responsibility Pattern solves.



💼 Think of an Expense Approval Workflow

Instead of one class deciding everything, each approver becomes an independent handler.

Employee

    │

    ▼

Team Lead

    │

    ▼

Manager

    │

    ▼

Director

    │

    ▼

CFO



Each handler has only two choices:

✅ Handle the request

➡️ Pass it to the next handler

The sender doesn't need to know who will ultimately process the request.



Why use the Chain of Responsibility Pattern?

✅ Eliminates long if-else chains

✅ Decouples the sender from the receiver

✅ Makes it easy to add or remove handlers

✅ Improves flexibility and maintainability



Design Principles Behind Chain of Responsibility

✔ Open/Closed Principle (OCP)

✔ Single Responsibility Principle (SRP)

✔ Loose Coupling

✔ Composition over Hard-coded Logic



Real-world Examples

💰 Expense Approval Systems

🌐 Spring Security Filter Chain

☕ Servlet Filters

🔐 Authentication & Authorization

🎧 Customer Support Escalation

📦 Request Validation Chains



📖 In this visual cheat sheet, you'll learn:

• The problem Chain of Responsibility solves

• How requests flow through handlers

• UML structure

• Java implementation

• Real-world use cases



💡 One simple rule to remember:

Each handler either processes the request or forwards it to the next handler.

That's the essence of the Chain of Responsibility Pattern.



⚖️ Chain of Responsibility vs Pipeline

These two concepts are often confused but solve different problems.

Chain of Responsibility

Each handler decides whether to process or forward the request.

Pipeline

Every stage executes in a predefined sequence.

👉 Chain = Decision-based delegation

👉 Pipeline = Ordered execution



📌 Connect with me on LinkedIn:

https://www.linkedin.com/in/nishant-lakhara-97037a16

I'd love to connect with fellow software engineers, architects, and technology enthusiasts!

#Java #DesignPatterns #BehavioralPatterns #ChainOfResponsibility #SystemDesign #SoftwareArchitecture #LowLevelDesign #LLD #SpringBoot #Backend #Programming #SoftwareEngineering #CleanCode #JavaDeveloper #Architecture #Developers #LearningInPublic