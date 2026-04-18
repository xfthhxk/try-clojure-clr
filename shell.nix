{ }:
let
  nixpkgs = fetchTarball "https://github.com/NixOS/nixpkgs/archive/c7f47036d3df2add644c46d712d14262b7d86c0c.tar.gz";
  pkgs = import nixpkgs { config = {}; overlays = []; };
  dotnet-sdk = pkgs.dotnetCorePackages.sdk_10_0;
  commonPackages = [
    dotnet-sdk
    pkgs.clojure
    pkgs.babashka
    pkgs.bbin
    pkgs.clj-kondo
    pkgs.cljfmt
    pkgs.dotnet-sdk_10
    pkgs.zsh
  ];

  linuxPackages = [
  ];

  # mac already has LLVM so don't need additional gcc deps
  macPackages = [
  ];
in

pkgs.mkShell {
  packages = commonPackages
    ++ (if pkgs.stdenv.isLinux then linuxPackages else [])
    ++ (if pkgs.stdenv.isDarwin then macPackages else []);

  shellHook = ''
    export DOTNET_ROOT="${dotnet-sdk}/share/dotnet";
    # This allows tools built for .NET 6/7/8/9 to run on .NET 10
    export DOTNET_ROLL_FORWARD=LatestMajor
    export PATH="$PATH:$HOME/.dotnet/tools"
    exec zsh
  '';
}
