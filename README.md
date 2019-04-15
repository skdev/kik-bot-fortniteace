# kik-bot-fortniteace
FortniteAce is a bot written for the Kik messenger application. It allows users to search Fortnite player stats and have it returned as an image. The bot also allows you to compare player stats.

## Getting Started

### Prerequisites
1. FortniteAce uses [Gradle](https://gradle.org) so this must be installed on your machine.
2. A bot must be created through Kik's website to hook this project [https://dev.kik.com](https://dev.kik.com)
3. Java 8 or higher
4. Port 80 open (this can be configured in config.json)

### Installing
1. Run `gradle build` in the kik-bot-fortniteace directory to download dependencies and build the project.
2. Open the `config.json` and set the name to your bots name and key to the API key generated through the Kik developer dashboard.

FortniteAce should now be ready and setup. You can run the project using the `gradle run` command.

## Contributing
We are happy to have contributions whether it is for small bug fixes or new pieces of major functionality. To contribute changes, you should first fork the upstream repository to your own GitHub account. You can then add a new remove for upstream and rebase any changes to
make keep up to date with upstream.

`git remote add upstream https://github.com/skdev/kik-bot-fortniteace.git`

The style guides the project uses is based on the [Google style guide](https://google.github.io/styleguide/javaguide.html)

## Authors
**Suraj Kumar**

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
