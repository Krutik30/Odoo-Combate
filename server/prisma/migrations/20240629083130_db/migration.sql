-- CreateTable
CREATE TABLE "user" (
    "id" SERIAL NOT NULL,
    "email" TEXT NOT NULL,
    "name" TEXT,
    "password" TEXT NOT NULL,
    "role" TEXT NOT NULL DEFAULT 'Admin',
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,

    CONSTRAINT "user_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "admindetail" (
    "user_id" INTEGER NOT NULL,
    "fullName" TEXT NOT NULL,
    "contactNumber" INTEGER NOT NULL,
    "profilePic" TEXT NOT NULL,

    CONSTRAINT "admindetail_pkey" PRIMARY KEY ("user_id")
);

-- CreateTable
CREATE TABLE "advertisedetail" (
    "user_id" INTEGER NOT NULL,
    "contactNumber" INTEGER NOT NULL,
    "department" TEXT NOT NULL,
    "companyAddress" TEXT NOT NULL,
    "industry" TEXT NOT NULL,
    "profilePic" TEXT NOT NULL,
    "ownerDetailId" TEXT NOT NULL,

    CONSTRAINT "advertisedetail_pkey" PRIMARY KEY ("user_id")
);

-- CreateTable
CREATE TABLE "spaceownerdetail" (
    "user_id" INTEGER NOT NULL,
    "fullName" TEXT NOT NULL,
    "contactNumber" INTEGER NOT NULL,
    "companyAddress" TEXT NOT NULL,
    "industry" TEXT NOT NULL,
    "profilePic" TEXT NOT NULL,

    CONSTRAINT "spaceownerdetail_pkey" PRIMARY KEY ("user_id")
);

-- CreateTable
CREATE TABLE "space" (
    "id" SERIAL NOT NULL,
    "name" TEXT NOT NULL,
    "description" TEXT NOT NULL,
    "address" TEXT NOT NULL,
    "location" TEXT NOT NULL,
    "ownerId" INTEGER NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,

    CONSTRAINT "space_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "advertise" (
    "id" SERIAL NOT NULL,
    "spaceId" INTEGER NOT NULL,
    "advertiserId" INTEGER NOT NULL,
    "startDate" TIMESTAMP(3) NOT NULL,
    "endDate" TIMESTAMP(3) NOT NULL,
    "status" TEXT NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,

    CONSTRAINT "advertise_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "performancematric" (
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

    CONSTRAINT "performancematric_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "booking" (
    "id" SERIAL NOT NULL,
    "spaceId" INTEGER NOT NULL,

    CONSTRAINT "booking_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "user_email_key" ON "user"("email");

-- CreateIndex
CREATE UNIQUE INDEX "performancematric_spaceId_key" ON "performancematric"("spaceId");

-- AddForeignKey
ALTER TABLE "user" ADD CONSTRAINT "adminDetails" FOREIGN KEY ("id") REFERENCES "admindetail"("user_id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "user" ADD CONSTRAINT "advertiserDetails" FOREIGN KEY ("id") REFERENCES "advertisedetail"("user_id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "user" ADD CONSTRAINT "spaceOwnerDetails" FOREIGN KEY ("id") REFERENCES "spaceownerdetail"("user_id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "space" ADD CONSTRAINT "space_ownerId_fkey" FOREIGN KEY ("ownerId") REFERENCES "spaceownerdetail"("user_id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "advertise" ADD CONSTRAINT "advertise_spaceId_fkey" FOREIGN KEY ("spaceId") REFERENCES "space"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "advertise" ADD CONSTRAINT "advertise_advertiserId_fkey" FOREIGN KEY ("advertiserId") REFERENCES "advertisedetail"("user_id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "performancematric" ADD CONSTRAINT "performancematric_spaceId_fkey" FOREIGN KEY ("spaceId") REFERENCES "space"("id") ON DELETE CASCADE ON UPDATE CASCADE;
