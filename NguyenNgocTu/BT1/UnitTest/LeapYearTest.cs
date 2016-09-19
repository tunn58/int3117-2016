using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using BaiTapKiemThu;
using System.Collections.Generic;

namespace UnitTest
{
    [TestClass]
    public class LeapYearTest
    {
        //weak normal ECT test IsLeapYear method
        [TestMethod]
        public void isLeapYearTestEvenlyDeviedBy4()
        {
            LeapYear target = new LeapYear();
            bool result = target.IsLeapYear(12);
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void isLeapYearTestEvenlyDeviedBy100()
        {
            LeapYear target = new LeapYear();
            bool result = target.IsLeapYear(300);
            Assert.IsFalse(result);
        }

        [TestMethod]
        public void isLeapYearTestEvenlyDeviedBy400()
        {
            LeapYear target = new LeapYear();
            bool result = target.IsLeapYear(2000);
            Assert.IsTrue(result);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void isLeapYearTestInvalidInput()
        {
            LeapYear target = new LeapYear();
            target.IsLeapYear(-42);
        }

        //Strong normal ECT test ListLeapYear method
        [TestMethod]
        public void ListLeapYearValidList()
        {
            LeapYear target = new LeapYear();
            var expected = new List<int>();
            expected.Add(2000);
            expected.Add(2004);
            expected.Add(2008);
            expected.Add(2012);

            var actual = target.ListLeapYear(2000, 2015);
            CollectionAssert.AreEqual(expected, actual);
        }

        [TestMethod]
        public void ListLeapYearaLessThanb()
        {
            LeapYear target = new LeapYear();
            var expected = new List<int>();
            var actual = target.ListLeapYear(2015, 2000);
            CollectionAssert.AreEqual(expected, actual);
        }

        [TestMethod]
        public void ListLeapYearLessYears()
        {
            LeapYear target = new LeapYear();
            var expected = new List<int>();
            expected.Add(2000);
            expected.Add(2004);
            expected.Add(2008);

            var actual = target.ListLeapYear(2000, 2015);
            CollectionAssert.AreNotEqual(expected, actual);
        }

        [TestMethod]
        public void ListLeapYearMoreYears()
        {
            LeapYear target = new LeapYear();
            var expected = new List<int>();
            expected.Add(2000);
            expected.Add(2004);
            expected.Add(2008);
            expected.Add(2012);
            expected.Add(2016);

            var actual = target.ListLeapYear(2000, 2015);
            CollectionAssert.AreNotEqual(expected, actual);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void ListLeapYearTestInvalida()
        {
            LeapYear target = new LeapYear();
            target.ListLeapYear(0, 2015);
        }

    }
}

