function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      let input = document.querySelector('#inputs textarea').value
      let restaurants = [];
      for (const el of JSON.parse(input)) {
         let [name, workersString] = el.toString().split(" - ")
         let workers = [];

         for (const worker of workersString.split(", ")) {
            let [name, salary] = worker.split(" ")
            workers.push({name, salary: Number(salary)})
         }
         if (restaurants.some(restaurant => restaurant.name === name)) {
            let currentRestaurant = restaurants.find(restaurant => restaurant.name === name)
            for (const worker of workers) {
               currentRestaurant.workers.push(worker)
            }
         } else {
            restaurants.push({name, workers})
         }

      }
      let bestRestaurantName = "";
      let bestAverageSalary = Number.MIN_SAFE_INTEGER;
      let bestWorkerSalary = 0;
      let bestWorkersList = [];

      for (const restaurant of restaurants) {
         let salarySum = 0;
         let currentBestSalary = Number.MIN_SAFE_INTEGER;
         for (const worker of restaurant.workers) {
            salarySum += worker.salary
            if (worker.salary > currentBestSalary) {
               currentBestSalary = worker.salary
            }
         }

         let currentAverageSalary = salarySum / restaurant.workers.length
         if (currentAverageSalary > bestAverageSalary) {
            bestRestaurantName = restaurant.name
            bestAverageSalary = currentAverageSalary
            bestWorkerSalary = currentBestSalary
            bestWorkersList = restaurant.workers.sort((a, b) => b.salary -a.salary)
         }
      }
      let bestWorkerListFinal = [];
      for (const worker of bestWorkersList) {
         bestWorkerListFinal.push(`Name: ${worker.name} With Salary: ${worker.salary}`)
      }
      document.querySelector('#bestRestaurant p').textContent = `Name: ${bestRestaurantName} Average Salary: ${bestAverageSalary.toFixed(2)} Best Salary: ${bestWorkerSalary.toFixed(2)}`
      document.querySelector('#workers p').textContent = bestWorkerListFinal.join(" ")
   }
}