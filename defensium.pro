# Versionamento

    + Gerar nova TAG

        git tag -a v1.3.0 -m "Lançamento de Versão v1.3.0"
        git push origin v1.3.0

    + Branch de Entrega

        git checkout main
        git merge --squash DEFENSIUMAPI20251506261216

    + Atualizar a main com a ultima versão de Lançamento

        git checkout main
        git fetch --all --tags
        git merge 1.4.0.0
        git push origin main

    + Atualizar a development com a ultima vesão da main

        git checkout development
        git fetch origin
        git merge origin/main
        git push origin development