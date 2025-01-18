using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using NUnit.Framework;
using SoftUniBazar.Controllers;
using SoftUniBazar.Data;
using SoftUniBazar.Models.Ad;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using SoftUniBazar.Data.Models;

namespace SoftUniBazar.Tests
{
    [TestFixture]
    public class AdControllerTests
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

            // Seed the in-memory database with categories for the test
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
            // Dispose of the in-memory database after each test
            _dbContext.Database.EnsureDeleted();
            _dbContext.Dispose();
        }

        [Test]
        public async Task Add_Get_ShouldReturnViewWithCategories()
        {
            // Act
            var result = await _controller.Add();

            // Assert
            var viewResult = result as ViewResult;
            Assert.IsNotNull(viewResult); // Ensure the result is a ViewResult

            var model = viewResult.Model as AdFormModel;
            Assert.IsNotNull(model); // Ensure the model is of type AdFormModel
            Assert.NotNull(model.Categories); // Ensure categories are not null
            Assert.AreEqual(2, model.Categories.Count()); // Check if two categories exist
        }

        [Test]
        public async Task Add_Post_ShouldRedirectToAll_OnValidModel()
        {
            // Arrange
            var adFormModel = new AdFormModel()
            {
                Name = "Test Ad",
                Description = "Test Description",
                CategoryId = 1,
                Price = 100,
                ImageUrl = "https://example.com/image.jpg"
            };

            // Act
            var result = await _controller.Add(adFormModel);

            // Assert
            var redirectToActionResult = result as RedirectToActionResult;
            Assert.IsNotNull(redirectToActionResult); // Ensure redirection
            Assert.AreEqual("All", redirectToActionResult.ActionName);
            Assert.AreEqual("Ad", redirectToActionResult.ControllerName);
        }

        [Test]
        public async Task Edit_Get_ShouldReturnViewWithCorrectModel_WhenAdExists()
        {
            // Arrange
            var ad = new Ad()
            {
                Id = 1,
                Name = "Test Ad",
                Description = "Test Description",
                CategoryId = 1,
                Price = 100,
                OwnerId = "testUserId",
                ImageUrl = "https://example.com/image.jpg",
                CreatedOn = System.DateTime.Now
            };
            _dbContext.Ads.Add(ad);
            _dbContext.SaveChanges();

            // Act
            var result = await _controller.Edit(1);

            // Assert
            var viewResult = result as ViewResult;
            Assert.IsNotNull(viewResult);

            var model = viewResult.Model as AdFormModel;
            Assert.IsNotNull(model);
            Assert.AreEqual("Test Ad", model.Name);
        }

        [Test]
        public async Task AddToCart_ShouldRedirectToCart_WhenAdIsAdded()
        {
            // Arrange
            var ad = new Ad() { Id = 1, Name = "Test Ad", Description = "Description", CategoryId = 1, Price = 100, OwnerId = "testUserId", ImageUrl = "url", CreatedOn = System.DateTime.Now };
            _dbContext.Ads.Add(ad);
            _dbContext.SaveChanges();

            // Act
            var result = await _controller.AddToCart(1);

            // Assert
            var redirectToActionResult = result as RedirectToActionResult;
            Assert.IsNotNull(redirectToActionResult);
            Assert.AreEqual("Cart", redirectToActionResult.ActionName);
            Assert.AreEqual("Ad", redirectToActionResult.ControllerName);
        }
    }
}
