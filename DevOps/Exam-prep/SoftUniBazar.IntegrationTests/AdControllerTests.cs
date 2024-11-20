using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using NUnit.Framework;
using SoftUniBazar.Controllers;
using SoftUniBazar.Data;
using SoftUniBazar.Data.Models;
using SoftUniBazar.Models.Ad;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;

namespace SoftUniBazar.Tests
{
    [TestFixture]
    public class AdControllerIntegrationTests
    {
        private BazarDbContext _dbContext;
        private AdController _controller;

        [SetUp]
        public void Setup()
        {
            // Set up in-memory database for testing
            var options = new DbContextOptionsBuilder<BazarDbContext>()
                .UseInMemoryDatabase(databaseName: "BazarDbTest")
                .Options;
            _dbContext = new BazarDbContext(options);

            // Seed the in-memory database with categories
            _dbContext.Categories.AddRange(new List<Category>
            {
                new Category { Id = 1, Name = "Category 1" },
                new Category { Id = 2, Name = "Category 2" }
            });
            _dbContext.SaveChanges();

            // Create the controller instance
            _controller = new AdController(_dbContext);

            // Mock user identity for controller context
            var mockUser = new ClaimsPrincipal(new ClaimsIdentity(new Claim[]
            {
                new Claim(ClaimTypes.NameIdentifier, "testUserId"),
            }));
            _controller.ControllerContext = new ControllerContext()
            {
                HttpContext = new DefaultHttpContext() { User = mockUser }
            };
        }

        [TearDown]
        public void TearDown()
        {
            // Clean up in-memory database after each test
            _dbContext.Database.EnsureDeleted();
            _dbContext.Dispose();
        }

        [Test]
        public async Task AddAd_ShouldInsertAdIntoDatabase()
        {
            // Arrange
            var adFormModel = new AdFormModel()
            {
                Name = "Integration Test Ad",
                Description = "This is a test ad",
                CategoryId = 1,
                Price = 150,
                ImageUrl = "https://example.com/test.jpg"
            };

            // Act
            var result = await _controller.Add(adFormModel);

            // Assert
            var redirectToActionResult = result as RedirectToActionResult;
            Assert.IsNotNull(redirectToActionResult);
            Assert.AreEqual("All", redirectToActionResult.ActionName);

            // Verify the ad has been inserted into the database
            var adsInDb = _dbContext.Ads.ToList();
            Assert.AreEqual(1, adsInDb.Count);  // Ensure one ad has been added
            Assert.AreEqual("Integration Test Ad", adsInDb[0].Name);
        }

        [Test]
        public async Task EditAd_ShouldUpdateAdInDatabase()
        {
            // Arrange: Add an ad to the database
            var ad = new Ad
            {
                Id = 1,
                Name = "Original Ad",
                Description = "Original Description",
                CategoryId = 1,
                Price = 100,
                OwnerId = "testUserId",
                ImageUrl = "https://example.com/original.jpg",
                CreatedOn = System.DateTime.Now
            };
            _dbContext.Ads.Add(ad);
            await _dbContext.SaveChangesAsync();

            // Prepare edit model
            var adFormModel = new AdFormModel()
            {
                Name = "Edited Ad",
                Description = "Edited Description",
                CategoryId = 1,
                Price = 150,
                ImageUrl = "https://example.com/edited.jpg"
            };

            // Act
            var result = await _controller.Edit(ad.Id, adFormModel);

            // Assert
            var redirectToActionResult = result as RedirectToActionResult;
            Assert.IsNotNull(redirectToActionResult);
            Assert.AreEqual("All", redirectToActionResult.ActionName);

            // Verify the ad has been updated in the database
            var updatedAd = await _dbContext.Ads.FindAsync(ad.Id);
            Assert.AreEqual("Edited Ad", updatedAd.Name);
            Assert.AreEqual("Edited Description", updatedAd.Description);
            Assert.AreEqual(150, updatedAd.Price);
            Assert.AreEqual("https://example.com/edited.jpg", updatedAd.ImageUrl);
        }
    }
}