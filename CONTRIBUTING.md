# Contributing to StyleBI

StyleBI Open Source welcomes your contributions to further improve the application. Thank you for considering to contribute to StyleBI. Please read and review the following before contributing:

- [Code of Conduct](#coc)
- [Have a Question or Concern?](#question)
- [Issues and Bugs](#issue)
- [Feature Requests](#feature)
- [How to Contribute](#contribute)
- [First Time Contributors](#first-time)
- [Getting Started](#getting-started)
- [Submitting Changes](#submitting)
- [Reviewing Pull Requests](#review)

### Code of Conduct <a name="coc"></a>

Please read and follow the [Code of Conduct](https://github.com/inetsoft-technology/stylebi/wiki/Code-of-Conduct) to maintain the open, welcoming and inclusive environment that the InetSoft team upholds.

### Have a Question or Concern? <a name="question"></a>

We appreciate your questions and concerns, however, please do not open an issue to discuss any questions or concerns you may have. Instead, please head over to our [discussion page](https://github.com/inetsoft-technology/stylebi/discussions) to get the conversation started.

### Issues and Bugs <a name="issue"></a>

We value your bug reports and issue submissions.

Before [reporting an issue](https://github.com/inetsoft-technology/stylebi/issues/new), please check first if a similar issue already exists. Bug reports should be as complete as possible. Please try and include the following:

* Complete steps to reproduce the issue.
* Any information about platform and environment that could be specific to the bug.
* Specific version of the product you are using.

### Feature Requests <a name="feature"></a>

If you have an idea or feature that you would like to be a part of the StyleBI application, please don't hesitate to submit an "enhancement" issue. To better understand your needs and requirements, please include as much detail as possible regarding the request.

## How to Contribute <a name="contribute"></a>

By contributing, you agree to our [Individual](https://github.com/inetsoft-technology/stylebi/wiki/InetSoft-Individual-Contributor-License-Agreement) or [Corporate](https://github.com/inetsoft-technology/stylebi/wiki/InetSoft-Corporate-Contributor-License-Agreement) Contributor License Agreement. When you create a pull request, you will be asked to sign the agreement. 

### First Time Contributors <a name="first-time"></a>

We recommend reading the following articles if you are unfamiliar with contributing to an open source project: \
\
[https://docs.github.com/en/get-started/exploring-projects-on-github/finding-ways-to-contribute-to-open-source-on-github](https://docs.github.com/en/get-started/exploring-projects-on-github/finding-ways-to-contribute-to-open-source-on-github) \
\
[https://docs.github.com/en/get-started/exploring-projects-on-github/contributing-to-a-project](https://docs.github.com/en/get-started/exploring-projects-on-github/contributing-to-a-project)

https://egghead.io/courses/how-to-contribute-to-an-open-source-project-on-github

### Getting Started With Contributing <a name="getting-started"></a>

Firstly, [fork the project](https://github.com/orgs/community/discussions/35849) into your own repository so that you can make changes to it without affecting the original project.

Once you are satisfied with your changes and wish to contribute back to the original project, you may [create a pull request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests).

The pull request will then be reviewed by our developers and accepted once they are deemed appropriate.

For an example of a forked project with steps on creating a new REST data source, please see the relevant [wiki page](placeholder).

### Submitting Changes <a name="submitting"></a>

Before submitting a pull request, please do the following:
1. Test the changes that you've made. Perform a rebuild of the Java libraries by performing the following command in the directory that you've forked and cloned the repository and ensure that all tests pass: 
    ```shell
    ./mvnw clean install
    ```

    or on Windows:

    ```powershell
    .\mvnw.cmd clean install
    ```
2. Search the repository's [pulls](https://github.com/inetsoft-technology/stylebi/pulls) and make sure there aren't any open or closed pull requests that match your submission. This will help us avoid duplicated efforts.
3. Rebase your changes by periodically updating your forked repository with the latest changes from the main StyleBI repository. Please squash commits into a single commit before merging for easier review by our developers.
4. Once the above is done, you are ready to submit a pull request. When the pull request is created, the CLAassistant bot will provide a link to our Contributor License Agreement which you will need to review and agree to before we can accept your changes.

### Reviewing Pull Requests <a name="review"></a>
The InetSoft team reserves the right to not accept pull requests from users who have not followed the contribution guidelines, the [InetSoft Code of Conduct](https://github.com/inetsoft-technology/stylebi/wiki/Code-of-Conduct), etc.

We look forward to working with you to get your pull request merged into the StyleBI application.