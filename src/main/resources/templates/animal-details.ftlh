<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <div class="card">
    <img src="${animal.imageUrl}" alt="Image of ${animal.name}"
     class="img-fluid mb-3"
     style="max-width: 400px; height: auto; display: block; margin: 0 auto;">

    <div class="card-body">
      <h1 class="card-title">${animal.name}</h1>
      <h5 class="card-subtitle mb-2 text-muted">Species: ${animal.species}</h5>
      <h6 class="card-subtitle mb-2 text-muted">Source: ${animal.source}</h6>
      <p class="card-text mt-3">${animal.description}</p>
      
      <div class="mt-4 d-flex gap-2">
        <a href="/animals/updateForm/${animal.animalId}" class="btn btn-outline-primary">Edit</a>
        <a href="/animals/delete/${animal.animalId}" class="btn btn-outline-danger"
           onclick="return confirm('Are you sure you want to delete this animal?');">
          Delete
        </a>
        <a href="/animals" class="btn btn-secondary ms-auto">Back to List</a>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>