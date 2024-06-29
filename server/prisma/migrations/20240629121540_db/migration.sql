/*
  Warnings:

  - You are about to drop the column `status` on the `advertise` table. All the data in the column will be lost.
  - You are about to drop the `admindetail` table. If the table is not empty, all the data it contains will be lost.
  - You are about to drop the `advertisedetail` table. If the table is not empty, all the data it contains will be lost.
  - You are about to drop the `performancematric` table. If the table is not empty, all the data it contains will be lost.
  - You are about to drop the `spaceownerdetail` table. If the table is not empty, all the data it contains will be lost.
  - A unique constraint covering the columns `[spaceId]` on the table `booking` will be added. If there are existing duplicate values, this will fail.
  - A unique constraint covering the columns `[adveriserId]` on the table `booking` will be added. If there are existing duplicate values, this will fail.
  - A unique constraint covering the columns `[performanceMetricId]` on the table `space` will be added. If there are existing duplicate values, this will fail.
  - Added the required column `adveriserId` to the `booking` table without a default value. This is not possible if the table is not empty.
  - Added the required column `price` to the `booking` table without a default value. This is not possible if the table is not empty.
  - Added the required column `updatedAt` to the `booking` table without a default value. This is not possible if the table is not empty.
  - Added the required column `image` to the `space` table without a default value. This is not possible if the table is not empty.
  - Added the required column `performanceMetricId` to the `space` table without a default value. This is not possible if the table is not empty.
  - Added the required column `price` to the `space` table without a default value. This is not possible if the table is not empty.
  - Added the required column `size` to the `space` table without a default value. This is not possible if the table is not empty.
  - Added the required column `status` to the `space` table without a default value. This is not possible if the table is not empty.
  - Added the required column `type` to the `space` table without a default value. This is not possible if the table is not empty.

*/
-- DropForeignKey
ALTER TABLE "advertise" DROP CONSTRAINT "advertise_advertiserId_fkey";

-- DropForeignKey
ALTER TABLE "performancematric" DROP CONSTRAINT "performancematric_spaceId_fkey";

-- DropForeignKey
ALTER TABLE "space" DROP CONSTRAINT "space_ownerId_fkey";

-- DropForeignKey
ALTER TABLE "user" DROP CONSTRAINT "adminDetails";

-- DropForeignKey
ALTER TABLE "user" DROP CONSTRAINT "advertiserDetails";

-- DropForeignKey
ALTER TABLE "user" DROP CONSTRAINT "spaceOwnerDetails";

-- AlterTable
ALTER TABLE "advertise" DROP COLUMN "status";

-- AlterTable
ALTER TABLE "booking" ADD COLUMN     "adveriserId" INTEGER NOT NULL,
ADD COLUMN     "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN     "price" INTEGER NOT NULL,
ADD COLUMN     "updatedAt" TIMESTAMP(3) NOT NULL;

-- AlterTable
ALTER TABLE "space" ADD COLUMN     "image" TEXT NOT NULL,
ADD COLUMN     "performanceMetricId" INTEGER NOT NULL,
ADD COLUMN     "price" INTEGER NOT NULL,
ADD COLUMN     "size" INTEGER NOT NULL,
ADD COLUMN     "status" TEXT NOT NULL,
ADD COLUMN     "type" TEXT NOT NULL;

-- DropTable
DROP TABLE "admindetail";

-- DropTable
DROP TABLE "advertisedetail";

-- DropTable
DROP TABLE "performancematric";

-- DropTable
DROP TABLE "spaceownerdetail";

-- CreateTable
CREATE TABLE "admin_detail" (
    "user_id" INTEGER NOT NULL,
    "fullName" TEXT NOT NULL,
    "contactNumber" INTEGER NOT NULL,
    "profilePic" TEXT NOT NULL,

    CONSTRAINT "admin_detail_pkey" PRIMARY KEY ("user_id")
);

-- CreateTable
CREATE TABLE "advertiser_detail" (
    "user_id" INTEGER NOT NULL,
    "fullName" TEXT NOT NULL,
    "contactNumber" INTEGER NOT NULL,
    "department" TEXT NOT NULL,
    "companyAddress" TEXT NOT NULL,
    "industry" TEXT NOT NULL,
    "profilePic" TEXT NOT NULL,
    "ownerDetailId" TEXT NOT NULL,

    CONSTRAINT "advertiser_detail_pkey" PRIMARY KEY ("user_id")
);

-- CreateTable
CREATE TABLE "spaceowner_detail" (
    "user_id" INTEGER NOT NULL,
    "fullName" TEXT NOT NULL,
    "contactNumber" INTEGER NOT NULL,
    "companyAddress" TEXT NOT NULL,
    "profilePic" TEXT NOT NULL,

    CONSTRAINT "spaceowner_detail_pkey" PRIMARY KEY ("user_id")
);

-- CreateTable
CREATE TABLE "performance_matric" (
    "id" SERIAL NOT NULL,
    "advertiseId" INTEGER NOT NULL,
    "advertiserId" INTEGER NOT NULL,
    "spaceId" INTEGER NOT NULL,
    "reach" INTEGER NOT NULL,
    "engagement" INTEGER NOT NULL,
    "converstion" INTEGER NOT NULL,
    "dayRange" INTEGER NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,

    CONSTRAINT "performance_matric_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "performance_matric_spaceId_key" ON "performance_matric"("spaceId");

-- CreateIndex
CREATE UNIQUE INDEX "booking_spaceId_key" ON "booking"("spaceId");

-- CreateIndex
CREATE UNIQUE INDEX "booking_adveriserId_key" ON "booking"("adveriserId");

-- CreateIndex
CREATE UNIQUE INDEX "space_performanceMetricId_key" ON "space"("performanceMetricId");

-- AddForeignKey
ALTER TABLE "admin_detail" ADD CONSTRAINT "admin_detail_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "user"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "advertiser_detail" ADD CONSTRAINT "advertiser_detail_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "user"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "spaceowner_detail" ADD CONSTRAINT "spaceowner_detail_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "user"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "space" ADD CONSTRAINT "space_ownerId_fkey" FOREIGN KEY ("ownerId") REFERENCES "spaceowner_detail"("user_id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "space" ADD CONSTRAINT "space_performanceMetricId_fkey" FOREIGN KEY ("performanceMetricId") REFERENCES "performance_matric"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "advertise" ADD CONSTRAINT "advertise_advertiserId_fkey" FOREIGN KEY ("advertiserId") REFERENCES "advertiser_detail"("user_id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "booking" ADD CONSTRAINT "booking_spaceId_fkey" FOREIGN KEY ("spaceId") REFERENCES "space"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "booking" ADD CONSTRAINT "booking_adveriserId_fkey" FOREIGN KEY ("adveriserId") REFERENCES "advertise"("id") ON DELETE CASCADE ON UPDATE CASCADE;
