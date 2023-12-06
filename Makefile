.DEFAULT_GOAL := build

build:
	./gradlew clean build -x test

test:
	./gradlew test

.PHONY: build