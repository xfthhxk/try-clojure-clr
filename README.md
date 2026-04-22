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


`cljr` is like `clj` for JVM Clojure. It will read a `deps-clr.edn` file
which is similar to `deps.edn`.
```shell
blazor dotnet tool install Clojure.Cljr --version 0.1.0-alpha11
dotnet cljr
```


### Build

This will manage gathering up all the deps and putting them in the `assemblies` directory
```
bb build:aot
dotnet publish -c Release -o ./assemblies/
cp foo.core.runtimeconfig.json ./assemblies/
```

Run:
```
dotnet ./assemblies/foo.core.exe
```

Babashka
Launch
```shell
bb dev:repl
```
