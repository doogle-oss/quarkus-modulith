<!--
Sync Impact Report
- Version change: 0.0.0 -> 1.0.0
- Modified principles:
  - N/A (initial ratification from template)
- Added sections:
  - Technical Standards and Constraints
  - Development Workflow and Quality Gates
- Removed sections:
  - None
- Templates requiring updates:
  - ✅ updated: .specify/templates/plan-template.md
  - ✅ updated: .specify/templates/spec-template.md
  - ✅ updated: .specify/templates/tasks-template.md
  - ⚠ pending: .specify/templates/commands/*.md (directory not present)
- Deferred TODOs:
  - TODO(RATIFICATION_DATE): confirm original adoption date if this project had a prior unwritten constitution
-->
# Quarkus Modulith Constitution

## Core Principles

### I. Modular Boundaries Are Enforced at Build and Runtime
Every production module MUST declare a stable public API surface and MUST keep non-API
packages internal. Access from one module into another module's internal package is forbidden.
Builds and application startup MUST fail fast when boundary violations are detected.
Rationale: strict encapsulation prevents erosion of a modulith into a tangled monolith.

### II. Event-Driven Collaboration Uses a Persistent Registry
Cross-module domain events MUST be published through a persistent event publication registry
that guarantees at-least-once delivery semantics. Event externalization adapters MUST preserve
per-aggregate ordering and support safe retry in multi-instance deployments.
Rationale: persistence and deterministic replay protect business workflows from message loss.

### III. Verification and Tests Are Non-Negotiable
All changes to module wiring, eventing, or public module APIs MUST include automated tests.
The project MUST provide module-scoped integration testing support and scenario-based end-to-end
verification, including cross-thread event capture where asynchronous execution is involved.
Rationale: architecture without executable verification becomes aspirational and drifts quickly.

### IV. Observability and Architecture Docs Are First-Class Artifacts
The framework MUST emit module-aware metrics and MUST generate architecture diagrams from source
module metadata during build or CI. Any feature that affects module topology or event flow MUST
update generated documentation artifacts and examples.
Rationale: maintainers need continuous visibility into architecture health and runtime behavior.

### V. Open-Source Operability and Contributor Experience
Public APIs MUST be documented with Javadoc. Each major module MUST include a focused README and
corresponding docs in `/docs`. The repository MUST include contribution guidelines, code of
conduct, and CI quality gates for unit, integration, and architecture verification on pull
requests.
Rationale: project sustainability depends on clarity, repeatability, and community trust.

## Technical Standards and Constraints

- Runtime baseline MUST be Java 21+ and Quarkus 3.x with Jakarta EE 10 APIs.
- Compatibility changes for future Quarkus 4.x or Mandrel updates MUST be validated by CI before
  release and documented in migration notes.
- Default persistence and outbox infrastructure MUST support JDBC schema auto-initialization.
- Generated diagrams MUST be exportable as PlantUML or Mermaid.
- Test utilities MUST include controllable time simulation with reset capability.

## Development Workflow and Quality Gates

- Significant features MUST start with a feature spec and implementation plan under `specs/`.
- Pull requests MUST pass:
  - Unit tests
  - Integration tests
  - Module boundary/architecture verification tests
  - Documentation checks for changed public APIs
- Complex architectural decisions MUST include concise "why" comments or ADR-style notes.
- Samples under `samples/` MUST demonstrate boundary enforcement, internal eventing, and
  externalization flows.

## Governance

This constitution overrides conflicting local conventions for this repository.

Amendment process:
- Changes MUST be proposed in a pull request that includes rationale, impact analysis, and any
  required template or documentation synchronization.
- Approval requires at least one maintainer review and successful CI.
- Ratified amendments MUST update `CONSTITUTION_VERSION` using semantic versioning:
  - MAJOR: incompatible governance changes or principle removal/redefinition.
  - MINOR: new principle/section or materially expanded obligations.
  - PATCH: clarifications, wording improvements, or typo fixes.

Compliance review:
- Every plan and PR review MUST include an explicit constitution compliance check.
- Violations MUST be fixed before merge or documented with a time-bound exception and owner.
- This file and dependent templates MUST remain synchronized.

**Version**: 1.0.0 | **Ratified**: TODO(RATIFICATION_DATE): confirm original adoption date | **Last Amended**: 2026-04-08
