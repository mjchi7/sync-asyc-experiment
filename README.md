# Spring Synchronous and Asynchronous Experiment
This codebase serves as the playground for experimenting between a synchronous controller and an asynchronous handler.
Particularly, the interests lies in the performance and behaviour between different programming mode under different scenario. So far, the following scenarios have been identified:
1. IO Intensive Tasks
2. CPU Intensive Tasks

## Structures
In this codebase, there are 2 Spring project:
- asynchronous: Contains Spring code for Webflux based handler
- synchronous: Contains Spring code for normal synchronous Spring MVC controller.

## Getting Started
To get started, first deploy one of the server:
`myke asynchronous/deploy` or `myke synchronous/deploy`
Once the server is up and running, run the test using rakyll/hey:
`myke test-concurrent-1000`

