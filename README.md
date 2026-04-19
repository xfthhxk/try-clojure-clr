# Getting Started

### Prerequisites
* Install `nix`
```shell
curl -L https://nixos.org/nix/install | sh -s -- --daemon
```
All commands must be run from within the nix-shell context
```shell
nix-shell
```

Restore deps (fetches deps)
```shell
dotnet restore
```

Babashka
Launch
```shell
bb dev:repl
```

Now you can connect on port 1667


### dotnet tool interactions
`cljr` is like `clj` for JVM Clojure. It will read a `deps-clr.edn` file
which is similar to `deps.edn`.
```shell
dotnet tool install Clojure.Cljr --version 0.1.0-alpha11
dotnet cljr
```
