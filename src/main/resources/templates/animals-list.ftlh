<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <header class="bg-dark text-white">
    <div class="container py-3 d-flex justify-content-between align-items-center">
      <div>
        <h1 class="h4 mb-1">${title}</h1>
        <p class="mb-0">Dynamic list of animals from the database</p>
      </div>
      <div>
        <a href="/animals/createForm" class="btn btn-outline-light me-2">Add Animal</a>
      </div>
    </div>
  </header>

  <section class="py-4 bg-light">
    <div class="container">
      <form class="d-flex" method="get" action="/animals/name">
        <input type="text" name="key" class="form-control me-2" placeholder="Search by name..." value="${key!}">
        <button type="submit" class="btn btn-primary">Search</button>
      <a href="/animals" class="btn btn-outline-secondary ms-2">Reset</a>
      </form>
    </div>
  </section>


  <main>
    <section class="album py-5 bg-body-tertiary">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-4">
          <#list animalsList as animal>
            <div class="col">
              <div class="card shadow-sm">
                <img src="${animal.imageUrl}" class="card-img-top" alt="Image of ${animal.name}">
                <div class="card-body">
                  <h5 class="card-title">${animal.name}</h5>
                  <p class="card-text">${animal.description?truncate(100, '...')}</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <a href="/animals/${animal.animalId}" class="btn btn-sm btn-outline-primary">View</a>
                    <small class="text-muted">Source: ${animal.source}</small>
                  </div>
                </div>
              </div>
            </div>
          </#list>
        </div>
      </div>
    </section>
  </main>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>